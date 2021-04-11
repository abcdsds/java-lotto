package step4.controller;


import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class Main {
    public static void main(String[] args) {
        LottoCount lottoCount =
                new LottoCount(InputView.getLottoPurchaseAmount(), InputView.getCountOfUserLottoNumber());
        InputView.printPurchaseUserLottoMessage();

        Lottos lottos = getLottos(lottoCount);
        ResultView.printLottos(lottos);

        Map<Rank, Long> matchResults = getMatchResults(lottos);
        ResultView.printMatchResults(matchResults);

        LottoBenefit lottoBenefitCalculator =
                new LottoBenefit(lottoCount.getLottoPurchaseAmount(), matchResults);
        ResultView.printBenefitResult(lottoBenefitCalculator.resultBenefit());
    }

    private static Lottos getLottos(LottoCount lottoCount) {
        LottoGeneration lottoGeneration =
                new LottoGeneration(NumberGeneration.getLottoAllNumberInRange(), lottoCount.getLottoCount());

        return Lottos.of(
                Stream.generate(InputView::getUserLottoNumber)
                        .limit(lottoCount.getCountOfUserLottoNumber())
                        .collect(collectingAndThen(toList(), Lottos::of)),
                lottoGeneration.getGeneratedLottos());
    }


    private static Map<Rank, Long> getMatchResults(Lottos lottos) {
        String winnersNumbers = InputView.getWinnersNumber();
        LottoWinnerNumber lottoWinnerNumber =
                new LottoWinnerNumber(InputView.getBonusNumber(), winnersNumbers);

        return lottoWinnerNumber.getMatchResults(lottos.getLottos());
    }
}
