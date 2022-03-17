package io.dataloder.dumpreader.author;


import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;

// similer to entity name when using JPA
@Table(value = "author_by_id") 
public class Author {

    // ordinal specifies the order of this column in the primary key. Incase we have multible pk columns.
    // This case has only one pk. so it is 0. 
    // PK can be either cluster key or partion key.
    // we specifiy this as type = PrimaryKeyType.PARTITIONED or type = PrimaryKeyType.CLUSTERE.
    // Refer to Cassandra to understand the difference betweek cluster and partion keys.
    
    @Id @PrimaryKeyColumn(name = "author_id", ordinal =  0, type = PrimaryKeyType.PARTITIONED) 
    private String id;

    @Column("author_name") 
    @CassandraType(type = Name.TEXT)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    
}
