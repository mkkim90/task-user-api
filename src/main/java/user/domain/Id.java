package user.domain;

public class Id {
    private String id;

    private Id(String id) {
        validRequired(id);
        this.id = id;
    }

    private void validRequired(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID는 필수 값입니다.");
        }
    }

    public static Id of(String id) {
        return new Id(id);
    }
}
