package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoMatchResultCountTest {

    @DisplayName("팩토리메소드 정상생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void FactoryTest(int value) {
        assertDoesNotThrow(() -> LottoMatchResultCount.of(value));
    }

    @DisplayName("팩토리메소드 익셉션 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9})
    void FactoryExceptionTest(int value) {
        assertThrows(IllegalArgumentException.class, () -> LottoMatchResultCount.of(value));
    }

    @DisplayName("message 일치하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getMatchResultsMessageTest(int value, int price) {
        String matchResultsMessage =
                LottoMatchResultCount.of(value).getMatchResultsMessage(1);
        String expectedMessage = value + "개 일치 (" + price + "원)-1개";
        assertEquals(matchResultsMessage, expectedMessage);
    }

    @DisplayName("benefit 일치하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getBenefitTest(int value, int price) {
        long benefit = LottoMatchResultCount.of(value).getBenefit(1);
        assertEquals(benefit, price);
    }


}