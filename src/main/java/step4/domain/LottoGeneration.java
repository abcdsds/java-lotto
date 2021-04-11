package step4.domain;


import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class LottoGeneration {

    private final List<Integer> numbers;
    private int count;

    public LottoGeneration(List<Integer> number, int count) {
        this.numbers = number;
        this.count = count;
    }

    public List<Lotto> getGeneratedLottos() {
        return IntStream.range(0, count)
                .mapToObj(index -> getGeneratedNumbers())
                .collect(toList());
    }


    private Lotto getGeneratedNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .map(LottoNumber::valueOf)
                .collect(collectingAndThen(toCollection(LinkedHashSet::new), Lotto::new));
    }
}
