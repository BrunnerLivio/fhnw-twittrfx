<?php
namespace App\Controller;

use App\Dto\BirdDto;
use App\Service\BirdService;
use Psr\Log\LoggerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpKernel\Attribute\MapRequestPayload;
use Symfony\Component\Routing\Annotation\Route;

class BirdController extends AbstractController
{
  public function __construct(
    private LoggerInterface $logger,
    private BirdService $birdService,
  ) {
  }


  #[Route('/bird', methods: ['GET'])]
  public function getAll(): Response
  {
    $birds = $this->birdService->getAll();

    return new JsonResponse($birds);
  }

  #[Route('/bird/{id}', methods: ['GET'])]
  public function getOne(int $id): Response
  {
    $this->logger->info('Getting bird with id ' . $id);

    $bird = $this->birdService->getOne($id);

    if (!$bird) {
      return new JsonResponse([
        'error' => 'Bird not found'
      ], 404);
    }

    return new JsonResponse($bird);
  }

  #[Route('/bird', methods: ['POST'])]
  public function saveAll(
    Request $request
  ): Response {
    $birds = json_decode($request->getContent(), true);

    $this->logger->info('Saving birds');

    $newBirds = [];

    foreach ($birds as $bird) {
      $birdDto = new BirdDto(
        $bird['name'],
        $bird['image'],
        $bird['shortDescription'],
        $bird['populationSize'],
        $bird['maximumLifeSpanInYears'],
        $bird['topSpeedInKmh'],
        $bird['weight'],
        $bird['length'],
        $bird['wingspan'],
        $bird['continents'],
        $bird['diet'],
        $bird['seasonalBehavior'],
        $bird['independentAge'],
        $bird['populationTrend'],
        $bird['populationStatus'],
        $bird['incubationPeriod'],
      );

      $newBirds[] = $birdDto;
    }

    $this->birdService->saveAll($newBirds);

    return new JsonResponse([
      'message' => 'Bird added'
    ]);
  }




}