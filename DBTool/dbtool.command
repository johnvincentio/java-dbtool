#!/bin/sh
#
# script to run java app DBTool
#
DEV_HOME=/Users/jv/Desktop/MyDevelopment/github/java/Utilities/java-dbtool/DBTool
#
cd $DEV_HOME
#
MYCP=$DEV_HOME/classes:$DEV_HOME/Jars/log4j-1.2.13.jar
MYCP=$MYCP:$DEV_HOME/Jars/db2java.zip
MYCP=$MYCP:$DEV_HOME/Jars/jt400.jar
MYCP=$MYCP:$DEV_HOME/Jars/commons-lang-2.3.jar
MYCP=$MYCP:$DEV_HOME/Jars/sqljdbc4.jar
MYCP=$MYCP:$DEV_HOME/Jars/mysql-connector-java-5.1.31-bin.jar

MY_FILE=/Users/jv/Desktop/MyDevelopment/github/repo_shell_scripts/mac/unix-scripts/dbtool/dbtool.xml
#
java -cp $MYCP -Xdock:name="Database Tool" io.johnvincent.dbtool.DBToolGui $MY_FILE
