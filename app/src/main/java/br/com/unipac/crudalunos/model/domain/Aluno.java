package br.com.unipac.crudalunos.model.domain;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "tb_aluno")
public class Aluno {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_aluno")
    private int alunoId;

    private String nome;

    @ColumnInfo(name = "curriculo_do_aluno")
    private String curriculo;

    public Aluno() {
    }

    public Aluno(int alunoId, String nome) {
        this.alunoId = alunoId;
        this.nome = nome;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return alunoId == aluno.alunoId &&
                Objects.equals(nome, aluno.nome) &&
                Objects.equals(curriculo, aluno.curriculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoId, nome, curriculo);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "alunoId=" + alunoId +
                ", nome='" + nome + '\'' +
                ", curriculo='" + curriculo + '\'' +
                '}';
    }
}
