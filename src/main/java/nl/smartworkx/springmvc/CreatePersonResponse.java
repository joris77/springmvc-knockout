package nl.smartworkx.springmvc;

/**
 * Response for create person request
 */
public class CreatePersonResponse {

    private final Long id;

    public CreatePersonResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
