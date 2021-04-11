package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoGenerationTest {

    @DisplayName("번호 생성 테스트")
    @Test
    void getGeneratedLottosTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGeneration lottoGeneration = new LottoGeneration(numbers, 1000);
        List<Lotto> generatedLottos = lottoGeneration.getGeneratedLottos();

        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Lotto lotto = new Lotto(lottoNumbers);

        assertTrue(generatedLottos.contains(lotto));
    }

}