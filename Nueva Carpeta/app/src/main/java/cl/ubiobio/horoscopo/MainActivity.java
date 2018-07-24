package cl.ubiobio.horoscopo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private boolean view = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.simpleDatePicker);
        simpleDatePicker.updateDate(1995,0,1);

        Button b1 = (Button) findViewById(R.id.birthDate);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int year = simpleDatePicker.getYear();
                int month = simpleDatePicker.getMonth();
                int day = simpleDatePicker.getDayOfMonth();

                setBirthDate(day, month, year);
                setZodiac(getZodiac(month,day));
                setChinese(getChinese(year));

                ViewFlipper vf_basic = (ViewFlipper)findViewById(R.id.vf_basic);
                vf_basic.setDisplayedChild(1);

                view = true;
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(view){
            ViewFlipper vf_basic = (ViewFlipper)findViewById(R.id.vf_basic);
            vf_basic.setDisplayedChild(0);
            view = false;
        }
    }

    private int getChinese(int year){
        year++;
        int zodiac = year%12;
        zodiac = zodiac + 8;
        if (zodiac>12){
            zodiac = zodiac - 12;
        }
        return zodiac;
    }
    private void setChinese(int zodiac){
        ImageView i_sign= (ImageView) findViewById(R.id.image_c_sign);
        ImageView l_sign_a = (ImageView) findViewById(R.id.logo_c_sign_a);
        ImageView l_sign_b = (ImageView) findViewById(R.id.logo_c_sign_b);
        TextView n_sign = (TextView) findViewById(R.id.name_c_sign) ;
        TextView t_sign = (TextView) findViewById(R.id.text_c_sign) ;
        ImageView e_sign = (ImageView) findViewById(R.id.element_logo_sign);
        TextView en_sign = (TextView) findViewById(R.id.element_text_sign) ;
        ImageView ta_sign = (ImageView) findViewById(R.id.tao_logo_sign);
        TextView  tan_sign= (TextView) findViewById(R.id.tao_text_sign) ;
        switch (zodiac){
            case 1:
                i_sign.setImageResource(R.drawable.rat);
                l_sign_a.setImageResource(R.drawable.rat_s);
                l_sign_b.setImageResource(R.drawable.rat_s);
                n_sign.setText("Rata");
                t_sign.setText("Se identifica por ser valiente, inteligente " +
                        " y provisto de recursos." );
                e_sign.setImageResource(R.drawable.water);
                en_sign.setText("Agua");
                ta_sign.setImageResource(R.drawable.yang);
                tan_sign.setText("Yang");
                break;
            case 2:
                i_sign.setImageResource(R.drawable.ox);
                l_sign_a.setImageResource(R.drawable.ox_s);
                l_sign_b.setImageResource(R.drawable.ox_s);
                n_sign.setText("Buey");
                t_sign.setText("Se considera un animal noble, tranquilo, le gusta estar en su rebaño");
                e_sign.setImageResource(R.drawable.earth);
                en_sign.setText("Tierra");
                ta_sign.setImageResource(R.drawable.yin);
                tan_sign.setText("Yin");
                break;
            case 3:
                i_sign.setImageResource(R.drawable.tiger);
                l_sign_a.setImageResource(R.drawable.tiger_s);
                l_sign_b.setImageResource(R.drawable.tiger_s);
                n_sign.setText("Tigre");
                t_sign.setText("Es la representación de la audacia," +
                        " tienden a ser obstinados y duros. ");
                e_sign.setImageResource(R.drawable.wood);
                en_sign.setText("Madera");
                ta_sign.setImageResource(R.drawable.yang);
                tan_sign.setText("Yang");
                break;
            case 4:
                i_sign.setImageResource(R.drawable.rabbit);
                l_sign_a.setImageResource(R.drawable.rabbit_s);
                l_sign_b.setImageResource(R.drawable.rabbit_s);
                n_sign.setText("Conejo");
                t_sign.setText("Son sensibles y tranquilos, buscan cariño, " +
                        "comprensión y estar protegidos.");
                e_sign.setImageResource(R.drawable.wood);
                en_sign.setText("Madera");
                ta_sign.setImageResource(R.drawable.yin);
                tan_sign.setText("Yin");
                break;
            case 5:
                i_sign.setImageResource(R.drawable.dragon);
                l_sign_a.setImageResource(R.drawable.dragon_s);
                l_sign_b.setImageResource(R.drawable.dragon_s);
                n_sign.setText("Dragon");
                t_sign.setText("Fuertes, poderosos, ambiciosos, protegen de los suyos. ");
                e_sign.setImageResource(R.drawable.earth);
                en_sign.setText("Tierra");
                ta_sign.setImageResource(R.drawable.yang);
                tan_sign.setText("Yang");
                break;
            case 6:
                i_sign.setImageResource(R.drawable.snake);
                l_sign_a.setImageResource(R.drawable.snake_s);
                l_sign_b.setImageResource(R.drawable.snake_s);
                n_sign.setText("Serpiente");
                t_sign.setText("Son habilidosos, " +
                        "aseguran siempre su presa y lo que les beneficia.");
                e_sign.setImageResource(R.drawable.fire);
                en_sign.setText("Fuego");
                ta_sign.setImageResource(R.drawable.yin);
                tan_sign.setText("Yin");
                break;
            case 7:
                i_sign.setImageResource(R.drawable.horse);
                l_sign_a.setImageResource(R.drawable.horse_s);
                l_sign_b.setImageResource(R.drawable.horse_s);
                n_sign.setText("Caballo");
                t_sign.setText("Trabajadores, nobles, sabios, las personas de este signo son " +
                        "optimistas, comunicativas y sociables. ");
                e_sign.setImageResource(R.drawable.fire);
                en_sign.setText("Fuego");
                ta_sign.setImageResource(R.drawable.yang);
                tan_sign.setText("Yang");
                break;
            case 8:
                i_sign.setImageResource(R.drawable.goat);
                l_sign_a.setImageResource(R.drawable.goat_s);
                l_sign_b.setImageResource(R.drawable.goat_s);
                n_sign.setText("Cabra");
                t_sign.setText("Es un signo que necesita descansar y reflexionar sobre todo lo pasa a su alrededor.");
                e_sign.setImageResource(R.drawable.earth);
                en_sign.setText("Tierra");
                ta_sign.setImageResource(R.drawable.yin);
                tan_sign.setText("Yin");
                break;
            case 9:
                i_sign.setImageResource(R.drawable.monkey);
                l_sign_a.setImageResource(R.drawable.monkey_s);
                l_sign_b.setImageResource(R.drawable.monkey_s);
                n_sign.setText("Mono");
                t_sign.setText("Tiene una inteligencia que le ayuda a salir " +
                        "siempre bien parado de todo.");
                e_sign.setImageResource(R.drawable.metal);
                en_sign.setText("Metal");
                ta_sign.setImageResource(R.drawable.yang);
                tan_sign.setText("Yang");
                break;
            case 10:
                i_sign.setImageResource(R.drawable.rooster);
                l_sign_a.setImageResource(R.drawable.rooster_s);
                l_sign_b.setImageResource(R.drawable.rooster_s);
                n_sign.setText("Gallo");
                t_sign.setText("Ha nacido para pregonar la llegada de la aurora y anunciar el sol naciente.");
                e_sign.setImageResource(R.drawable.metal);
                en_sign.setText("Metal");
                ta_sign.setImageResource(R.drawable.yin);
                tan_sign.setText("Yin");
                break;
            case 11:
                i_sign.setImageResource(R.drawable.dog);
                l_sign_a.setImageResource(R.drawable.dog_s);
                l_sign_b.setImageResource(R.drawable.dog_s);
                n_sign.setText("Perro");
                t_sign.setText("Son cariñosos, amigables, honestos, responsables, buscan la lealtad");
                e_sign.setImageResource(R.drawable.earth);
                en_sign.setText("Tierra");
                ta_sign.setImageResource(R.drawable.yang);
                tan_sign.setText("Yang");
                break;
            case 12:
                i_sign.setImageResource(R.drawable.pig);
                l_sign_a.setImageResource(R.drawable.pig_s);
                l_sign_b.setImageResource(R.drawable.pig_s);
                n_sign.setText("Cerdo");
                t_sign.setText(" Son considerados valientes y admiradores. " +
                        "Viven en paz y armonía con todo ");
                e_sign.setImageResource(R.drawable.water);
                en_sign.setText("Agua");
                ta_sign.setImageResource(R.drawable.yin);
                tan_sign.setText("Yin");
                break;


        }
    }

    private int getZodiac(int month, int day){
        month++;
        int zodiac = 0;
        switch (month){
            case 1:
                if(day>=20){ zodiac = 1;
                }else{ zodiac = 12;
                }break;
            case 2:
                if(day>=19){ zodiac = 2;
                }else{ zodiac = 1;
                }break;
            case 3:
                if(day>=21){ zodiac = 3;
                }else{ zodiac = 2;
                }break;
            case 4:
                if(day>=20){ zodiac = 4;
                }else{ zodiac = 3;
                }break;
            case 5:
                if(day>=21){ zodiac = 5;
                }else{ zodiac = 4;
                }break;
            case 6:
                if(day>=21){ zodiac = 6;
                }else{ zodiac = 5;
                }break;
            case 7:
                if(day>=23){ zodiac = 7;
                }else{ zodiac = 6;
                }break;
            case 8:
                if(day>=23){ zodiac = 8;
                }else{ zodiac = 7;
                }break;
            case 9:
                if(day>=23){ zodiac = 9;
                }else{ zodiac = 8;
                }break;
            case 10:
                if(day>=23){ zodiac = 10;
                }else{ zodiac = 9;
                }break;
            case 11:
                if(day>=22){ zodiac = 11;
                }else{ zodiac = 10;
                }break;
            case 12:
                if(day>=22){ zodiac = 12;
                }else{ zodiac = 11;
                }break;
        }
        return zodiac;
    }
    private void setZodiac(int zodiac){
        ImageView i_sign= (ImageView) findViewById(R.id.image_sign);
        ImageView l_sign_a = (ImageView) findViewById(R.id.logo_sign_a);
        ImageView l_sign_b = (ImageView) findViewById(R.id.logo_sign_b);
        TextView n_sign = (TextView) findViewById(R.id.name_sign) ;
        TextView t_sign = (TextView) findViewById(R.id.text_sign) ;

        switch (zodiac){
            case 3:
                i_sign.setImageResource(R.drawable.aries);
                l_sign_a.setImageResource(R.drawable.aries_s);
                l_sign_b.setImageResource(R.drawable.aries_s);
                n_sign.setText("Aries");
                t_sign.setText("Entre el 21 de Marzo y 19 de Abril "+
                        "Es una persona llena de energía y entusiasmo. " +
                        "Pionero y aventurero, le encantan los retos, la libertad y las nuevas ideas. ");
                break;
            case 4:
                i_sign.setImageResource(R.drawable.taurus);
                l_sign_a.setImageResource(R.drawable.taurus_s);
                l_sign_b.setImageResource(R.drawable.taurus_s);
                n_sign.setText("Tauro");
                t_sign.setText("Abril 20 – Mayo 20 " +
                        "Suele ser práctico, decidido y tener una gran fuerza de voluntad. " +
                        "Son personas estables y conservadores, y seguirán de forma leal un líder en el que tienen confianza.");
                break;
            case 5:
                i_sign.setImageResource(R.drawable.gemini);
                l_sign_a.setImageResource(R.drawable.gemini_s);
                l_sign_b.setImageResource(R.drawable.gemini_s);
                n_sign.setText("Geminis");
                t_sign.setText("Mayo 21 – Junio 20 " +
                        "Su carácter es doble y bastante complejo y contradictorio. " +
                        "Por un lado es versátil, pero por el otro puede ser insincero.");
                break;
            case 6:
                i_sign.setImageResource(R.drawable.cancer);
                l_sign_a.setImageResource(R.drawable.cancer_s);
                l_sign_b.setImageResource(R.drawable.cancer_s);
                n_sign.setText("Cancer");
                t_sign.setText("Junio 21 – Julio 22 " +
                        "Puede ser desde tímido y aburrido hasta brillante y famoso. " +
                        "Son conservadores y les encanta la seguridad y el calor de su hogar. ");
                break;
            case 7:
                i_sign.setImageResource(R.drawable.leo);
                l_sign_a.setImageResource(R.drawable.leo_s);
                l_sign_b.setImageResource(R.drawable.leo_s);
                n_sign.setText("Leo");
                t_sign.setText("Julio 23 – Agosto 22 " +
                        "Es el signo más dominante del zodiaco. También es creativo y extrovertido." +
                        " Son los reyes entre los humanos, de la misma forma que los leones son los reyes en el reino animal.");
                break;
            case 8:
                i_sign.setImageResource(R.drawable.virgo);
                l_sign_a.setImageResource(R.drawable.virgo_s);
                l_sign_b.setImageResource(R.drawable.virgo_s);
                n_sign.setText("Virgo");
                t_sign.setText("Agosto 23 – Septiembre 22 " +
                        "El único signo representado por una mujer, es un signo caracterizado por su precisión, " +
                        "su convencionalidad, su actitud reservado y su afán, a veces hasta obsesión, con la limpieza. ");
                break;
            case 9:
                i_sign.setImageResource(R.drawable.libra);
                l_sign_a.setImageResource(R.drawable.libra_s);
                l_sign_b.setImageResource(R.drawable.libra_s);
                n_sign.setText("Libra");
                t_sign.setText("Septiembre 23 – Octubre 22 " +
                        "Tienen encanto, elegancia y buen gusto, y son amables y pacíficos. " +
                        "Les gusta la belleza y la armonía y son capaces de ser imparcial ante conflictos.");
                break;
            case 10:
                i_sign.setImageResource(R.drawable.scorpio);
                l_sign_a.setImageResource(R.drawable.scorpio_s);
                l_sign_b.setImageResource(R.drawable.scorpio_s);
                n_sign.setText("Escorpion");
                t_sign.setText("Octubre 23 – Noviembre 21 " +
                        "Es un signo intenso con una energía emocional única en todo el zodiaco. " +
                        "Aunque puedan aparecer tranquilos, tienen una agresión y magnetismo interno escondidos dentro. ");
                break;
            case 11:
                i_sign.setImageResource(R.drawable.sagita);
                l_sign_a.setImageResource(R.drawable.sagita_s);
                l_sign_b.setImageResource(R.drawable.sagita_s);
                n_sign.setText("Sagitario");
                t_sign.setText("Noviembre 22 - Diciembre 21 " +
                        "Son versátiles y les encanta la aventura y lo desconocido. Tienen la mente abierta a nuevas ideas y experiencias" +
                        " y mantienen un actitud optimista incluso cuando las cosas se les ponen difíciles. ");
                break;
            case 12:
                i_sign.setImageResource(R.drawable.capri);
                l_sign_a.setImageResource(R.drawable.capri_s);
                l_sign_b.setImageResource(R.drawable.capri_s);
                n_sign.setText("Capricornio");
                t_sign.setText("Diciembre 22 – Enero 19 " +
                        "Es un de los signos del zodiaco más estables, seguros y tranquilos. Son trabajadores, " +
                        "responsables y prácticos y dispuestos a persistir hasta sea necesario para conseguir su objetivo. ");
                break;
            case 1:
                i_sign.setImageResource(R.drawable.aqua);
                l_sign_a.setImageResource(R.drawable.aqua_s);
                l_sign_b.setImageResource(R.drawable.aqua_s);
                n_sign.setText("Aquario");
                t_sign.setText("Enero 20 – Febrero 18 " +
                        "Hay dos tipos: uno es tímido, sensible, y paciente. " +
                        "El otro tipo es exuberante, vivo y puede llegar a esconder las profundidades de su personalidad debajo de un aire frívolo.");
                break;
            case 2:
                i_sign.setImageResource(R.drawable.picis);
                l_sign_a.setImageResource(R.drawable.picis_s);
                l_sign_b.setImageResource(R.drawable.picis_s);
                n_sign.setText("Picis");
                t_sign.setText("Febrero 19 – Marzo 20 " +
                        "Tiene una personalidad tranquila, paciente y amable. " +
                        "Son sensibles a los sentimientos de los demás y responden con simpatía y tacto al sufrimiento de los demás.");
                break;
        }
    }

    private void setBirthDate(int day, int month, int year){
        Date date = new Date(year,month,day);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        String day_week = getDayWeek(c.get(Calendar.DAY_OF_WEEK));
        String mes = getMes(month);

        TextView Textyear = (TextView)findViewById(R.id.year);
        Textyear.setText(""+year);
        TextView Textdayw = (TextView)findViewById(R.id.day_week);
        Textdayw.setText(day_week+", ");
        TextView Textmonth = (TextView)findViewById(R.id.month);
        Textmonth.setText(mes);
        TextView Textday = (TextView)findViewById(R.id.day);
        Textday.setText(day+" de ");
    }

    private String getMes(int month){
        String mes = "";
        switch (month){
            case 0:
                mes = "Enero";
                break;
            case 1:
                mes = "Febrero";
                break;
            case 2:
                mes = "Marzo";
                break;
            case 3:
                mes = "Abril";
                break;
            case 4:
                mes = "Mayo";
                break;
            case 5:
                mes = "Junio";
                break;
            case 6:
                mes = "Julio";
                break;
            case 7:
                mes = "Agosto";
                break;
            case 8:
                mes = "Septiembre";
                break;
            case 9:
                mes = "Octubre";
                break;
            case 10:
                mes = "Noviembre";
                break;
            case 11:
                mes = "Diciembre";
                break;
        }
        return mes;
    }

    private String getDayWeek(int dayOfWeek){
        String day_week = "";
        switch (dayOfWeek) {
            case 3:
                day_week = "Lunes";
                break;
            case 4:
                day_week = "Martes";
                break;
            case 5:
                day_week = "Miercoles";
                break;
            case 6:
                day_week = "Jueves";
                break;
            case 7:
                day_week = "Viernes";
                break;
            case 1:
                day_week = "Sabado";
                break;
            case 2:
                day_week = "Domingo";
                break;
        }
        return day_week;
    }
}
