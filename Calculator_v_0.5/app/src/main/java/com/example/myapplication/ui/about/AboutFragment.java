package com.example.myapplication.ui.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.myapplication.R;

public class AboutFragment extends Fragment {
    private static TextView about;
    private EditText EmailSubject;
    private EditText EmailMessage;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about, container, false);
        about=(TextView) root.findViewById(R.id.aboutText);
        setAbout();

        EmailSubject=(EditText) root.findViewById(R.id.aboutEmailSubject);
        EmailMessage=(EditText) root.findViewById(R.id.aboutEmailMessage);

        Button sendButton = (Button) root.findViewById(R.id.aboutEMailSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
        return root;
    }

    private void sendMail()
    {
        String subject = EmailSubject.getText().toString();
        String message = EmailMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"programmingisgreatooo@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Выберите приложение Email"));

    }

    @SuppressLint("SetTextI18n")
    private void setAbout()
    {
        about.setText("Приветствуем Вас в нашем приложении \n " +
                "Оно представляет из себя калькулятор с некоторыми прочими приколюхами\n" +
                "Список фич:\n" +
                "1.Калькулятор (Из названия все понятно- математические рассчеты)\n" +
                "2.Исследование двух прямых на пересечения (по точкам и направляющим векторам)\n" +
                "3.Построение графиков (просмотр общей формы графика) по формуле y=f(x), где Вы можете задать f(x)\n" +
                "4.Заметки - можете записать сюда формулы, подсказки и прочие штуки, которые Вам необходимы\n" +
                "(чтобы удалить заметку задержите палец на ней)\n" +
                "Если возникли вопросы, предложения и рецензии, можете написать нам на почту:\n" +
                "programmingisgreatooo@gmail.com\n" +
                "Спасибо:)");
    }

}