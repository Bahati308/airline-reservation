#!/usr/bin/env bash
docker build -t airline-reservation-system:1 .
docker run -p 8080:8080 -it airline-reservation-system:1
