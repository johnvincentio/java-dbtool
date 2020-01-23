
# Usage

Start the application `dbtool.command <path-to-dbtool.xml`

Create your own `dbtool.xml` file. For example:

```
<dbtool>

	<scenario>
		<name>MySQL56 - one</name>
		<driver>com.mysql.jdbc.Driver</driver>
		<url>jdbc:mysql:</url>
		<username>user1</username>
		<password>pwd1</password>
		<databasename>localhost:3306</databasename>
		<schema>mydb1</schema>
		<system>mysql</system>
	</scenario>

	<scenario>
		<name>MySQL56 - two</name>
		<driver>com.mysql.jdbc.Driver</driver>
		<url>jdbc:mysql:</url>
		<username>user2</username>
		<password>pwd2</password>
		<databasename>localhost:3306</databasename>
		<schema>mydb2</schema>
		<system>mysql</system>
	</scenario>

</dbtool>
```




# DBTool

At Github, create repository `java-dbtool`

repo: https://github.com/johnvincentio/java-dbtool

```
cd /Users/jv/Desktop/MyDevelopment/github/java/Utilities
create-repo java-dbtool
```

Remove non-relevant files.

## Add `README.md`

```
cd java-dbtool
```

Create `README.md`

```
For details, see DBTool/README.md
```

## Start Eclipse

in Finder

* select `/Users/jv/Desktop/MyDevelopment/github/java/Utilities/java-dbtool`
* Right click, Services
  * eclipse-jee

## Create Java Project

* File, New, Project
* Java Project

Settings

* Project Name: DBTool
* Use default location
* JRE; Use an execution environment JRE: JavaSE-1.8
* Create separate folders for sources and class files

* Default output folder: `DBTool/classes`

## Package

Select `src`

* Right click, New, Package
* `io.johnvincent`

Copy code to this package and change package names.

## Script file

`/Users/jv/Desktop/MyDevelopment/github/java/Utilities/java-dbtool/DBTool/dbtool.command`


## Create Alias

In Finder

* select `dbtool.command`
* right click, Make Alias
* move alias to `/Users/jv/Desktop/MyDevelopment/github/repo_shell_scripts/mac/JVTools/`
* rename to `dbtool.command`

# END
