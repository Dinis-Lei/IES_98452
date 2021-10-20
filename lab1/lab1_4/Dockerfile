# escape=` 

FROM postgres:11
LABEL author="Jawad Hasan"

ENV POSTGRES_PASSWORD sasa
ENV PSTGRES_DB sampledb

COPY dbscriptsOrder/ /docker-entrypoint-initdb.d/
