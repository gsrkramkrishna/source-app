# source-app
app register --name source-app --type source --uri maven://com.gsrk.dataflow:source:jar:0.0.1-SNAPSHOT

app register --name processor-app --type processor --uri maven://com.gsrk.dataflow:processor:jar:0.0.1-SNAPSHOT

app register --name sink-app --type sink --uri maven://com.gsrk.dataflow:sink:jar:0.0.1-SNAPSHOT


stream create --name log-data --definition 'source-app | processor-app | sink-app'

stream deploy --name log-data
