FROM ghcr.io/brunnerlivio/fhnw-twittrfx-base:latest

RUN COMPOSER_ALLOW_SUPERUSER=1 composer install

EXPOSE 8000
CMD symfony server:start