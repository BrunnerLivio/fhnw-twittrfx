FROM php:8.2-cli

RUN apt-get update -y && apt-get install -y libmcrypt-dev libonig-dev zip unzip

RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer
RUN docker-php-ext-install pdo mbstring
RUN curl -sS https://get.symfony.com/cli/installer > composer_installer
RUN bash composer_installer --install-dir=/usr/local/bin


WORKDIR /app
COPY . /app

RUN COMPOSER_ALLOW_SUPERUSER=1 composer install

EXPOSE 8000
CMD symfony server:start