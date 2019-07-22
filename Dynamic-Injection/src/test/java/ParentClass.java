public class ParentClass {

    private String name;

    public ParentClass(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println(this.getClass().getName());

    }
}
