package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(){
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){

            if (desenvolvedores.size() < vagas){
                desenvolvedores.add(desenvolvedor);
                return true;
            }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){

        for (Desenvolvedor dev : desenvolvedores) {
            if (desenvolvedor.isFullstack()){
                desenvolvedores.add(desenvolvedor);
                    return true;
            }
        }
        return false;
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;

        for (Desenvolvedor dev : desenvolvedores) {
            soma += dev.calcularSalario();
        }
        
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer soma = 0;

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile){
                soma += desenvolvedores.size();
            }
        }

        return soma;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> devs = new ArrayList<>();
        Double primeiroSalario = devs.get(0).calcularSalario();

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (primeiroSalario >= salario){
                devs.add(desenvolvedor);
            }
        }
        return devs;
    }

    public Desenvolvedor buscarMenorSalario(){

        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor dev = new Desenvolvedor();
        Double menorSalario = Double.MAX_VALUE;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (menorSalario > desenvolvedor.calcularSalario()){
                menorSalario = desenvolvedor.calcularSalario();
                dev = desenvolvedor;
            }
        }
        return dev;
    }


}
