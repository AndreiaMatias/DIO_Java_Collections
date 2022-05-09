import java.util.*;

public class JavaOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("Ordem aleatória: ");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("Dark", "drama", 60));
            add(new Serie("that 70's show", "comédia", 25));
        }};
        for (Serie serie : minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("Ordem inserção: ");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("Dark", "drama", 60));
            add(new Serie("that 70's show", "comédia", 25));
        }};
        for (Serie serie : minhasSeries1) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("Ordem natural: ");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        System.out.println(minhasSeries2);


    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio){
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        return Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
    }
}
