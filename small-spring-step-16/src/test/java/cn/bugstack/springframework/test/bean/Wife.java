package cn.bugstack.springframework.test.bean;

public class Wife {

    private Husband husband;
    private IMother mother; // 婆婆

    public String queryHusband() {
        String result = "Wife.husband、Mother.callMother：";
        String test1 = mother.callMother();
//        return "Wife.husband、Mother.callMother：" + mother.callMother();
        return result + test1;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public IMother getMother() {
        return mother;
    }

    public void setMother(IMother mother) {
        this.mother = mother;
    }

}
