package io.dataloder.dumpreader.connection;


import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

// We'll expose the propery into properties.yml called datastax.astra
@ConfigurationProperties(prefix = "datastax.astra")
public class DatastaxAstraConfigs {
    
    private File secureConnectionBundle;

    public File getSecureConnectionBundle() {
        return secureConnectionBundle;
    }

    public void setSecureConnectionBundle(File secureConnectionBundle) {
        this.secureConnectionBundle = secureConnectionBundle;
    }

    
}

