package com.app.sb3t.persitence.version;

import liquibase.exception.LiquibaseException;
import liquibase.sdk.Main;
import org.apache.commons.lang3.ArrayUtils;

import static liquibase.integration.commandline.Main.run;

/**
 * java -jar sb3t-persistence-version-1.0-SNAPSHOT.jar --url="jdbc:h2:mem:testdb;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1" --username=sa --changeLogFile=.db-changelog-master.yaml generateChangeLog
 */
public class LiquibaseLauncher extends Main {

    public static void main(String[] args) {
        String[] defaultArgs = { "--changeLogFile=db/db-changelog-master.yml" };
        String[] newArgs = ArrayUtils.addAll(defaultArgs, args);
        try {
            run(newArgs);
        } catch (LiquibaseException e) {
            System.out.printf("Liquibase error %s%n", e.getMessage());
            System.exit(-1);
        } catch (Exception e) {
            System.out.printf("Liquibase error %s%n", e.getMessage());
            System.exit(-1);
        }
        System.exit(0);
    }

}