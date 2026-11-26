package cl.duoc.urban.config;

import cl.duoc.urban.model.Blog;
import cl.duoc.urban.repository.BlogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initBlogs(BlogRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                String detalleTallas = """
                {
                  "subtitulo": "Como elegir tu talla",
                  "intro": "Elegir la talla correcta es importante para que tus zapatillas sean comodas y se ajusten correctamente a tu pie. Antes de realizar tu compra, te recomendamos medir la longitud de tu pie en centimetros.",
                  "videoUrl": "https://www.youtube.com/embed/DnIV27zJNcI?si=zVYrPuoYcCUAWfY8",
                  "notaTabla": "Utiliza esta tabla para encontrar la talla que corresponde a la medida de tu pie. Compara los centimetros obtenidos con la tabla antes de elegir tus zapatillas.",
                  "consejos": [
                    { "icono": "👣", "titulo": "Mide ambos pies", "texto": "A veces un pie puede ser ligeramente mas grande que el otro." },
                    { "icono": "📏", "titulo": "Quedate con la medida mas grande", "texto": "Utiliza como referencia el pie que tenga mayor longitud." },
                    { "icono": "📋", "titulo": "Revisa la tabla antes de comprar", "texto": "Compara tu medida en centimetros con nuestra tabla de tallas." },
                    { "icono": "🧦", "titulo": "Ten en cuenta tus calcetines", "texto": "Mide pensando en el tipo de calcetines que normalmente usaras." },
                    { "icono": "👟", "titulo": "Estas entre dos tallas", "texto": "Considera que tan ajustadas o comodas prefieres tus zapatillas." },
                    { "icono": "✨", "titulo": "La comodidad es lo primero", "texto": "Una buena talla te permitira disfrutar tus zapatillas sin molestias." }
                  ]
                }
                """;

                String detalleCulturaPop = """
                {
                  "intro": "El streetwear dejo de ser solo ropa comoda para el dia a dia: hoy es un lenguaje visual que mezcla musica, skate, anime y redes sociales. En UrbanStyle creemos que cada prenda cuenta una historia — aca te contamos de donde viene esta cultura y por que sigue marcando tendencia.",
                  "cita1": "\\"Cuando la calle se toma la moda\\"",
                  "nota1": "De los callejones de Nueva York a las luces de neon de hoy — el streetwear cambio de forma, pero nunca de actitud.",
                  "historia": [
                    { "icono": "🗽", "titulo": "De los callejones de Nueva York...", "texto": "Ahi nacio todo — funcionalidad, identidad y actitud, mucho antes de las pasarelas." },
                    { "icono": "💡", "titulo": "...a las luces de neon de hoy", "texto": "El streetwear cambio de forma, pero nunca de esencia." },
                    { "icono": "🧬", "titulo": "Cada coleccion cuenta una historia", "texto": "Identidad, resistencia y estilo propio en cada prenda." },
                    { "icono": "✍️", "titulo": "Y esa historia sigue escribiendose", "texto": "La calle sigue marcando el ritmo — nosotros solo la seguimos de cerca." }
                  ],
                  "cita2": "\\"Los pixeles tambien visten streetwear: hoy la moda urbana se mezcla con la cultura gamer y el anime, creando un estilo que nacio en la pantalla y se llevo a la calle.\\"",
                  "nota2": "En definitiva, la cultura gamer no solo cambio nuestra forma de jugar: cambio la forma en que el mundo se viste. La proxima vez que salgas a la calle, mira a tu alrededor: el proximo nivel de la moda ya esta activo.",
                  "gamer": [
                    { "icono": "🎮", "titulo": "La pantalla como pasarela", "texto": "El gaming dejo de ser solo un hobby — hoy influye directamente en como se viste toda una generacion." },
                    { "icono": "⚡", "titulo": "Estetica neon, actitud real", "texto": "Colores vibrantes, luces y texturas digitales se trasladaron de las salas gamer a las prendas streetwear." },
                    { "icono": "🌸", "titulo": "El anime como inspiracion", "texto": "Sin copiar personajes, muchas colecciones toman su paleta de colores y su energia visual." },
                    { "icono": "🕹️", "titulo": "Una cultura, un estilo de vida", "texto": "Vestirse streetwear gamer es mostrar identidad — no solo lo que juegas, sino quien eres." }
                  ]
                }
                """;

                repo.save(new Blog(
                    "tallas",
                    "Como elegir la talla correcta de zapatillas",
                    "Como elegir correctamente tu talla de zapatillas antes de realizar tu compra.",
                    "https://cdn.runrepeat.com/storage/gallery/post/27375/shoe-size-conversion-24432934-main.jpg",
                    "Guias",
                    "Equipo UrbanStyle",
                    detalleTallas
                ));

                repo.save(new Blog(
                    "cultura-pop",
                    "Cultura pop y lifestyle juvenil",
                    "Descubre tendencias y estilos que forman parte de la cultura urbana.",
                    "https://img.magnific.com/foto-gratis/grupos-juveniles-antecedentes-inspirados-pop_23-2151494837.jpg?semt=ais_hybrid&w=740&q=80",
                    "Cultura Urbana",
                    "Equipo UrbanStyle",
                    detalleCulturaPop
                ));
            }
        };
    }
}
