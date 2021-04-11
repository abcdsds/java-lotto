package step4.domain;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(Lottos userLottos, List<Lotto> autoLottos) {
        return Stream.of(userLottos.getLottos(), autoLottos)
                .flatMap(Collection::stream)
                .collect(collectingAndThen(toList(), Lottos::new));
    }

    public static Lottos of(List<String> userLottos) {
        return userLottos.stream()
                .map(Lotto::of)
                .collect(collectingAndThen(toList(), Lottos::new));
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
