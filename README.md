# week10_project_news_manager
Java/Hibernate/Spark 'news manager pair project with Gemma'
<br>
<h2>News Manager</h2>
Launch <b>src/main/java/controllers/MainController.class</b>
<br>
then goto  <b>http://localhost:4567/</b></p>
<h4>Setup - MacOS</h4>

INSTALL PSQL - Requires HomeBrew<Br>
<b>$ brew install postgres</b>
<br>
Start PSQL Server <br>
To have postgresql services running after every restart and login:<br>
<b> $ brew services start postgresql </b>
<br>
Or, if you don't want/need a background service you can just run one time:<br>
<b> $ pg_ctl -D /usr/local/var/postgres start </b>
<br><br>
<b>TROUBLESHOOT</b>
<br>
PSQL - Clean Wipe if required / old
<br>
<b> $ brew uninstall --force postgresql</b>


<b>UPDATE BREW AND ALL PACKAGES INCLUDING PSQL</b>
<br>
<b>$ brew update
<br>
$ brew upgrade</b>
<br>
<b>TRY REINSTALLING PSQL </b>
<br>
<b>$ 'brew reinstall postgresql'</b>
<br>
<b>REMOVE PSQL - MAY LOSE ALL ASSOCCIATED DATA! </b>
<br>
<b> $ rm -rf /usr/local/var/postgres </b>
<br>
Fresh install of PostGres 
<br>
<b> $ brew install postgres </b>
<br>
Check postGres Version
<br>
<b> $ postgres -V </b>  

NoDB ? From Bash terminal manually createDB
<br>

<b> $ createdb monstermunchdb </b>
