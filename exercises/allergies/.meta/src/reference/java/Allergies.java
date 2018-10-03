import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

class Allergies {

    private int score;

    Allergies(int scoreInput) {
        score = scoreInput;
    }

    List<Allergen> getList() {
        return EnumSet.allOf(Allergen.class).stream()
                .filter(this::isAllergicTo)
                .collect(Collectors.toList());
    }

    boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore()) == allergen.getScore();
    }
}
