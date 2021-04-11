package step4.domain;


import step4.exception.IllegalLottoNumberException;
import step4.exception.IllegalLottoRangeException;

public class LottoNumber {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 46;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(String lottoNumber) {
        return valueOf(Integer.parseInt(lottoNumber));
    }

    public static LottoNumber valueOf(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        if (LottoNumberCache.cache[lottoNumber] != null)
            return LottoNumberCache.cache[lottoNumber];

        return new LottoNumber(lottoNumber);
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_RANGE_MIN
                || lottoNumber >= LOTTO_NUMBER_RANGE_MAX)
            throw new IllegalLottoRangeException("1 ~ 45 이내의 숫자만 입력할수 있습니다");
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    private static class LottoNumberCache {
        static final int low = LOTTO_NUMBER_RANGE_MIN;
        static final int high = LOTTO_NUMBER_RANGE_MAX;
        static final LottoNumber[] cache = new LottoNumber[high];

        static {
            for (int i = 1; i < cache.length; i++) {
                cache[i] = new LottoNumber(i);
            }
        }

        private LottoNumberCache() {
        }
    }
}
