package hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade gread;

    public Member(Long id, String name, Grade gread) {
        this.id = id;
        this.name = name;
        this.gread = gread;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGread() {
        return gread;
    }

    public void setGread(Grade gread) {
        this.gread = gread;
    }
}
