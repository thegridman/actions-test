package com.oracle.coherence.examples.actions;

import com.oracle.bedrock.testsupport.MavenProjectFileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class KeyToolTest
    {
    @Test
    public void shouldCreateKeys() throws Exception
        {
        KeyTool.assertCanCreateKeys();
        File fileBuild = MavenProjectFileUtils.locateBuildFolder(KeyToolTest.class);
        KeyTool.KeyAndCert caCert     = KeyTool.createCACert(fileBuild, "test-ca", "PKCS12");
        assertThat(caCert, is(notNullValue()));
        KeyTool.KeyAndCert keyAndCert = KeyTool.createKeyCertPair(fileBuild, caCert, "test");
        assertThat(keyAndCert, is(notNullValue()));
        }
    }
