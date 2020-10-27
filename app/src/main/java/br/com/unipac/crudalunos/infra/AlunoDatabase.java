package br.com.unipac.crudalunos.infra;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.unipac.crudalunos.model.domain.Aluno;
import br.com.unipac.crudalunos.model.repository.AlunoDAO;
import br.com.unipac.crudalunos.util.DateRoomConverter;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
@TypeConverters({DateRoomConverter.class})
public abstract class AlunoDatabase extends RoomDatabase {

    public abstract AlunoDAO getAlunoDao();

    private static AlunoDatabase alunoDatabase;

    public static AlunoDatabase getInstance(Context context) {
        if (null == alunoDatabase) {
            alunoDatabase = Room.databaseBuilder(context, AlunoDatabase.class, "aluno.db").allowMainThreadQueries().build();
        }
        return alunoDatabase;
    }

    public void cleanUp() {
        alunoDatabase = null;
    }
}
