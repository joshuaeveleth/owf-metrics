dataSource {
	pooled = true
	driverClassName = "org.hsqldb.jdbcDriver"
	username = "sa"
	password = ""
}

hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
}

// environment specific settings
environments {
	development {
		dataSource {
            pooled = true
            url = "jdbc:hsqldb:file:${basedir}/metricsDb;shutdown=true"
		    //TO-DO Address the issue with bootstrap vs. metricsDb.script...
            dbCreate = "create" // one of 'create', 'create-drop','update
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS"
		    }
	    }
    }
	test {
		dataSource {
			dbCreate = "create-drop"
			url = "jdbc:hsqldb:mem:testDb"
		}
	}
	production {
		dataSource {
            pooled = true
			url = "jdbc:hsqldb:file:metricsDb;shutdown=true"
            dbCreate = "none"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS"
		}
	}
    }
    with_hsql {
        dataSource {
            pooled = true
            dbCreate="none"
            url = "jdbc:hsqldb:file:${basedir}/metricsDb;shutdown=true"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS"
            }
        }
    }
    with_hsql_empty {
        dataSource {
            pooled = true
            dbCreate="none"
            url = "jdbc:hsqldb:mem:emptyDb"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS"
            }
        }
    }
    with_mysql  {
        dataSource {
            pooled = true
            dbCreate = "none"
            driverClassName = "com.mysql.jdbc.Driver"
            url="jdbc:mysql://owfdb01:3306/metric_build"
            username = "owfbuild"
            password = "0wf-bu1!d"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
        }
    }
    with_mysql_empty  {
        dataSource {
            pooled = true
            dbCreate = "none"
            driverClassName = "com.mysql.jdbc.Driver"
            url="jdbc:mysql://owfdb01:3306/metric_empty"
            username = "owfbuild"
            password = "0wf-bu1!d"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
        }
    }
    with_oracle {
        dataSource {
            pooled = true
            dbCreate="none"
            driverClassName="oracle.jdbc.OracleDriver"
            url="jdbc:oracle:thin:@owfdb03.goss.owfgoss.org:1521:XE"
            username="METRIC_BLD"
            password = "METRIC_BLD"
            dialect="org.hibernate.dialect.Oracle10gDialect"
            // dialect='org.hibernate.dialect.Oracle9Dialect'
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1 FROM DUAL"
            }
        }
    }
    with_oracle_empty {
        dataSource {
            pooled = true
            dbCreate="none"
            driverClassName="oracle.jdbc.OracleDriver"
            url="jdbc:oracle:thin:@owfdb03.goss.owfgoss.org:1521:XE"
            username="METRIC_EMPTY"
            password = "METRIC_EMPTY"
            dialect="org.hibernate.dialect.Oracle10gDialect"
            // dialect='org.hibernate.dialect.Oracle9Dialect'
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1 FROM DUAL"
            }
        }
    }
    with_postgres {
        dataSource {
            pooled = true
            dbCreate = "none"
            username="owfbuild"
            password = "0wf-bu1!d"
            driverClassName = "org.postgresql.Driver"
            url = "jdbc:postgresql://owfdb02:5432/metric_build"
            dialect="org.hibernate.dialect.PostgreSQLDialect"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }

        }
    }
    with_postgres_empty {
        dataSource {
            pooled = true
            dbCreate = "none"
            username="owfbuild"
            password = "0wf-bu1!d"
            driverClassName = "org.postgresql.Driver"
            url = "jdbc:postgresql://owfdb02:5432/metric_empty"
            dialect="org.hibernate.dialect.PostgreSQLDialect"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }

        }
    }
    with_sql_server {
        dataSource {
            pooled = true
            dbCreate = "none"
            driverClassName = "net.sourceforge.jtds.jdbc.Driver"
            url = "jdbc:jtds:sqlserver://owfdb02:1443/metric_build"
            username="owfbuild"
            password = "0wf-bu1!d"
            dialect="ozone.owf.hibernate.OWFSQLServerDialect"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
        }
    }
    with_sql_server_empty {
        dataSource {
            pooled = true
            dbCreate = "none"
            driverClassName = "net.sourceforge.jtds.jdbc.Driver"
            url = "jdbc:jtds:sqlserver://owfdb02:1443/metric_empty"
            username="owfbuild"
            password = "0wf-bu1!d"
            dialect="ozone.owf.hibernate.OWFSQLServerDialect"
            properties {
                minEvictableIdleTimeMillis = 180000
                timeBetweenEvictionRunsMillis = 180000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = true
                validationQuery = "SELECT 1"
            }
        }
    }
}