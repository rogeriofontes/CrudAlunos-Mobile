package br.com.unipac.crudalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.unipac.crudalunos.infra.AlunoDatabase;
import br.com.unipac.crudalunos.model.domain.Aluno;
import br.com.unipac.crudalunos.ui.adapters.AlunoAdapter;

public class MainActivity extends AppCompatActivity {
    ListView listaDeAlunosLV;
    AlunoAdapter alunoAdapter;

    private AlunoDatabase alunoDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeAlunosLV = (ListView) findViewById(R.id.listaDeAlunosLV);
        alunoDatabase = AlunoDatabase.getInstance(this);

        /*Aluno aluno = new Aluno(1, "Rogerio");
        alunoDatabase.getAlunoDao().insert(aluno);

        Aluno aluno1 = new Aluno(2, "MAria");
        alunoDatabase.getAlunoDao().insert(aluno1);

        Aluno aluno2 = new Aluno(3, "Antonio");
        alunoDatabase.getAlunoDao().insert(aluno2);

        Aluno aluno3 = new Aluno(4, "Patricia");
        alunoDatabase.getAlunoDao().insert(aluno3);
     */
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Aluno> alunoList = alunoDatabase.getAlunoDao().list();

        alunoAdapter = new AlunoAdapter(alunoList, this);
        listaDeAlunosLV.setAdapter(alunoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                return true;
            case R.id.menu_cadastrar:
                Intent intent = new Intent(this, AdicionarAlunoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}