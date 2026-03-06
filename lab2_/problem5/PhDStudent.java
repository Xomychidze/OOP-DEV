public class PhDStudent extends Person {
    private String major;
    private String researchTopic;

    public PhDStudent(String name, int age, String major, String researchTopic) {
        super(name, age);
        this.major = major;
        this.researchTopic = researchTopic;
    }

    public String getMajor() { return major; }
    public String getResearchTopic() { return researchTopic; }
    public void setMajor(String major) { this.major = major; }
    public void setResearchTopic(String researchTopic) { this.researchTopic = researchTopic; }

    // PhD students cannot have high-maintenance pets like dogs
    @Override
    protected boolean canAcceptPet(Animal animal) {
        if (animal instanceof Dog) {
            return false;
        }
        return true;
    }

    @Override
    public String getOccupation() {
        return "PhD Student - " + major + " (Research: " + researchTopic + ")";
    }
}
