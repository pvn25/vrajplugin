# vrajplugin

To facilitate studies on this huge GitHub data volume, the GHTorrent web-site publishes a MYSQL dump of (some) GitHub data quarterly. Unfortunately, developers using these published data dumps face challenges with re-spect to the time required to parse and ingest the data, the space required to store it, and the latency of their queries.
To help address these challenges, we developed a data adaptor as an Eclipse plugin, which efficiently handles this dump.
The plugin offers an interactive interface through which users can explore and select any field in any table. After extracting the data selected by the user, the parser exports it in easy-to-use spreadsheets. We hope that using this plugin
will facilitate further studies on the GitHub data as a whole.

In order to install the plugin, first, download this jar file and put it in plugins and features folder in the Eclipse path (and restart Eclipse if it is running). A menu item called GitHub Dump  will be added to the Eclipse menu bar (shown with a red ellipse in figurefig), which is the plugin trigger. By clicking on this menu item, a three-page wizard appears.
The plugin user-interaction is guided by a three-step wizard.

(step 1) After obtaining from the user the path in the local file system where the input data dump can be found, it  automatically detects all the available tables and their fields and shows them in the second page which is shown in Figure. Anticipating the possibility that the tables included in the data dump may change the providers may, in the future, add additional information, for example regarding code branches our plugin is capable of dynamically detecting the tables.

(step 2) In the next step, the user can select the desired fields from different tables to be extracted. There are op-
tions like select all / deselect all, the output format and valid characters to be read. Then, after hitting Finish,
the extracting process begins. This process may take from seconds for extracting a few columns from a few tables, up
to a couple of hours for extracting the whole data set. This time is not comparable with huge amounts of time needed
for SQL manipulation of the data set (even with the rst step which is SQL importing, and, as discussed previously
may take several days for a regular machine).

(step 3) Then, in order to facilitate the tracking of the progress, the third window shows the progress and summary
of the extracted data (Figure).

For more detail information you can go to: https://www.youtube.com/watch?v=XBZbrG5oUHQ
For questions and concerns please email me at pvn251@gmail.com
