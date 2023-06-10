<?php

namespace App\Service;

use App\Dto\BirdDto;
use Psr\Log\LoggerInterface;

class BirdService
{
  private $birds = [];
  private string $dataLocation = 'data';

  public function __construct(
    private LoggerInterface $logger,
  ) {
    $this->load();
  }


  private function load(): void
  {
    $this->logger->info('Data location: ' . $this->dataLocation);

    if (!file_exists($this->dataLocation)) {
      mkdir($this->dataLocation, 0777, true);
    }

    if (!file_exists($this->dataLocation . '/birds.json')) {
      file_put_contents($this->dataLocation . '/birds.json', json_encode([]));
    }

    $birdsRaw = file_get_contents($this->dataLocation . '/birds.json');

    $this->birds = json_decode($birdsRaw, true);
  }

  private function save(): void
  {
    file_put_contents($this->dataLocation . '/birds.json', json_encode($this->birds));
  }

  public function getAll(): array
  {
    return $this->birds;
  }

  public function getOne(int $id): ?BirdDto
  {
    return $this->birds[$id] ?? null;
  }


  public function saveAll(array $birds): void
  {
    $this->birds = $birds;
    $this->save();
  }

}