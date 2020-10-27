package br.com.unipac.crudalunos.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.unipac.crudalunos.R;
import br.com.unipac.crudalunos.model.domain.Aluno;

public class AlunoAdapter extends BaseAdapter {
    private List<Aluno> alunoList = new ArrayList<>();
    private Context context = null;

    public AlunoAdapter(List<Aluno> alunoList, Context context) {
        this.alunoList = alunoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return !alunoList.isEmpty() ? alunoList.size() : 0;
    }

    @Override
    public Aluno getItem(int posicao) {
        return !alunoList.isEmpty() ? alunoList.get(posicao) : new Aluno();
    }

    @Override
    public long getItemId(int posicao) {
        return !alunoList.isEmpty() ? alunoList.get(posicao).getAlunoId() : 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        Aluno aluno = getItem(posicao);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View novoLayout = inflater.inflate(R.layout.aluno_item, null);

        TextView idTv = (TextView) novoLayout.findViewById(R.id.idTv);
        TextView nameTv = (TextView) novoLayout.findViewById(R.id.nameTv);

        idTv.setText(String.valueOf(aluno.getAlunoId()));
        nameTv.setText(aluno.getNome());

        return novoLayout;
    }
}
