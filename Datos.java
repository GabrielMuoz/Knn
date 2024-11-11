class Datos {

    private Integer age;
    private Integer educationalNum;
    private String education;
    private Integer horas_trabajo;

    public Datos( Integer age, Integer educationalNum, String education, Integer horas_trabajo) {
        this.age = age;
        this.educationalNum = educationalNum;
        this.education = education;
        this.horas_trabajo=horas_trabajo;
    }


    public Integer getAge() {
        return age;
    }

    public Integer getEducationalNum() {
        return educationalNum;
    }

    public String getEducation() {
        return education;
    }

    public Integer getHoras_trabajo(){return horas_trabajo;}

    @Override
    public String toString() {
        return "Datos{" +
                " Edad=" + age +
                ", Años de Estudio=" + educationalNum +
                ", education='" + education + '\'' +
                ", horas trabajadas a la semana= "+ horas_trabajo+
                '}';
    }
}
