# vrajplugin

To facilitate studies on this huge GitHub data volume, the GHTorrent web-site publishes a MYSQL dump of (some) GitHub data quarterly. Unfortunately, developers
using these published data dumps face challenges with re-spect to the time required to parse and ingest the data, the space required to store it, and the latency of their queries.
To help address these challenges, we developed a data adaptor as an Eclipse plugin, which eciently handles this dump.
The plugin offers an interactive interface through which users can explore and select any eld in any table. After extract-
ing the data selected by the user, the parser exports it in easy-to-use spreadsheets. We hope that using this plugin
will facilitate further studies on the GitHub data as a whole.
