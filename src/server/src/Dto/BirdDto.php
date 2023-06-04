<?php
namespace App\Dto;

use Symfony\Component\Validator\Constraints as Assert;

class BirdDto
{
  public function __construct(
    public readonly string $name,
    public readonly string $image,
    public readonly string $shortDescription,
    public readonly string $populationSize,
    public readonly string $maximumLifeSpanInYears,
    public readonly string $topSpeedInKmh,
    public readonly string $weight,
    public readonly string $length,
    public readonly string $wingspan,
    public readonly string $continents,
    public readonly string $diet,
    public readonly string $seasonalBehavior,

    public readonly string $independentAge,
    public readonly string $populationTrend,

    public readonly string $populationStatus,
    public readonly string $incubationPeriod,
  ) {
  }

}