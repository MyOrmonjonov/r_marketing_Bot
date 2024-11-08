package org.example;

import java.util.ArrayList;
import java.util.List;

public interface DB {

    List<TgUser> tgUser=new ArrayList<>();
    List<Tariflar>tariflar=new ArrayList<>();
    List<Hizmatlar>hizmatlar=new ArrayList<>();


    static void genericFunction(){
       tariflar.add(new Tariflar(1L,"\uD83E\uDD47 Start      ",500,"\n" +
               "\uD83D\uDCCCReels 12 ta \n" +
               "\uD83D\uDCCCStories 26 ta \n" +
               "\uD83D\uDCCC2 ta Maxsus target reklama ro'liklari\n" +
               "- Kontent reja shakllantirish: Oylik asosiy postlar va storieslar rejasini tayyorlash va auditoriya bilan ishash\n" +
               "- Profil boshqaruvi: Profilni optimizatsiya qilish, muntazam haftalik postlar va stories joylashtirish.\n" +
               "- Asosiy analitika: Profil o‘sishi va eng muhim ko‘rsatkichlar bo‘yicha qisqacha hisobot.\n" +
               "- Targeting: Xizmat ko‘rsatilayotgan auditoriyani tahlil qilish va boshlang'ich targeting.\n","\n\n\uD83D\uDCCC Reels: 12 видео\n" +
               "\uD83D\uDCCC Stories: 26 историй\n" +
               "\uD83D\uDCCCРекламные ролики: 2 специальных таргетированных видео\n" +
               "- Разработка контент-плана: Подготовка ежемесячного плана публикаций и сторис, взаимодействие с аудиторией.\n" +
               "- Управление профилем: Оптимизация профиля, регулярное размещение постов и историй каждую неделю.\n" +
               "- Основная аналитика: Краткий отчет по росту профиля и ключевым показателям.\n" +
               "- Таргетинг: Анализ аудитории и начальный таргетинг для привлечения клиентов.\n","\uD83E\uDD47 Старт"));
       tariflar.add(new Tariflar(2L,"\uD83E\uDD48 Standart ",800,"\n" +
               "\n- Kontent va dizayn: Profil uchun chiroyli va o‘ziga xos kontent va imidj yaratish.\n" +
               "\uD83D\uDCCCReels 8 ta \n" +
               "\uD83D\uDCCCStories 21 ta \n" +
               "\uD83D\uDCCC4 ta Maxsus target reklama ro'liklari\n" +
               "\uD83D\uDCCCTelegram kanal\n" +
               "- Pro targeting: To‘g‘ri auditoriyani aniqlash va segmentatsiya qilish har oy target konversiyasi hisoboti.\n" +
               "- Oylik tahlil: Profil va postlar natijalarining muntazam tahlili.\n" +
               "- Instagram Reels va storieslar: Profil auditoriya qamrovini oshirish va mijozlarni jalb qilish uchun kreativ videolar. \n","\n\n- Контент и дизайн: Создание уникального и привлекательного контента и имиджа для профиля.\n" +
               "\uD83D\uDCCCReels: 8 видео\n" +
               "\uD83D\uDCCCStories: 21 история\n" +
               "\uD83D\uDCCC Рекламные ролики: 4 специальных таргетированных видео\n" +
               "\uD83D\uDCCCТелеграм-канал\n" +
               "- Профессиональный таргетинг: Определение и сегментация целевой аудитории, ежемесячный отчет по конверсии.\n" +
               "- Ежемесячный анализ: Постоянный анализ профиля и результатов публикаций.\n" +
               "- Reels и Stories: Креативные видео для увеличения охвата аудитории и привлечения клиентов.\n","\uD83E\uDD48 Стандарт "));
       tariflar.add(new Tariflar(3L,"\uD83E\uDD49 Gold",1200,"\n" +
               "\n- Brend rivojlantirish: Klinika va shaxsiy profilni kuchli brendga aylantirishga qaratilgan maxsus yondashuvli strategiya.  (Instagram, Facebook, Telegram kanal va trafik jalb qilish)\n" +
               "\uD83D\uDCCCReels 12 ta \n" +
               "\uD83D\uDCCCStories 26 ta \n" +
               "\uD83D\uDCCC4 ta Maxsus target reklama ro'liklari\n" +
               "\uD83D\uDCCCTelegram kanal va guruh optimizatsiyasi\n" +
               "- Pro Target reklama: Mijozlar oqimini ko‘paytirish uchun maxsus targeting va reklama.\n" +
               "- Keng qamrovli kontent strategiyasi: Profil uchun rejalashtirilgan, chuqur o‘ylangan kontent strategiyasi.\n" +
               "- Retarget: Klinikaga qayta murojaatlarni oshirish uchun maxsus qayta targeting.\n","\n\n- Развитие бренда: Специальная стратегия для превращения клиники и личного профиля в сильный бренд (Instagram, Facebook, Telegram-канал, привлечение трафика).\n" +
               "\uD83D\uDCCC Reels: 12 видео\n" +
               "\uD83D\uDCCC Stories: 26 историй\n" +
               "\uD83D\uDCCC Рекламные ролики: 4 специальных таргетированных видео\n" +
               "\uD83D\uDCCCОптимизация Телеграм-канала и группы\n" +
               "- Профессиональная таргетированная реклама: Специальный таргетинг и реклама для увеличения потока клиентов.\n" +
               "- Комплексная стратегия контента: Глубоко продуманная стратегия контента для профиля.\n" +
               "- Ретаргетинг: Специальный ретаргетинг для увеличения возврата клиентов в клинику.\n","\uD83E\uDD49 Золото"));
       tariflar.add(new Tariflar(4L,"\uD83C\uDFC5 VIP",4500,":\n" +
               "\n" +
               "To‘liq xizmatlar paketi: Instagram, Facebook, Telegram kanal va trafik jalb qilish, Youtube kanal\n" +
               "\uD83D\uDCCCReels 30 ta \n" +
               "\uD83D\uDCCCStories 100 ta \n" +
               "\uD83D\uDCCCYoutube podcast bir oyda 2 ta \n" +
               "\uD83D\uDCCC10 ta Maxsus target reklama ro'liklari\n" +
               "\uD83D\uDCCCTelegram kanal va guruh optimizatsiyasi\n" +
               "- Raqobat tahlili va monitoring: Raqobatchilarni kuzatish va strategiyani o‘z vaqtida yangilash. \n" +
               "- VIP targeting va kengaytirilgan analitika: Har bir reklama kampaniyasini monitoring qilish va optimallashtirish va har oylik konversiya xisoboti.\n" +
               "- PR va hamkorlik reklamalari\n","\n\n- Полный пакет услуг: Instagram, Facebook, Телеграм-канал, привлечение трафика, YouTube-канал.\n" +
               "\uD83D\uDCCCReels: 30 видео\n" +
               "\uD83D\uDCCC Stories: 100 историй\n" +
               "\uD83D\uDCCC YouTube-подкаст: 2 выпуска в месяц\n" +
               "\uD83D\uDCCCРекламные ролики: 10 специальных таргетированных видео\n" +
               "\uD83D\uDCCCОптимизация Телеграм-канала и группы\n" +
               "- Анализ конкурентов и мониторинг: Отслеживание конкурентов и своевременное обновление стратегии.\n" +
               "- VIP-таргетинг и расширенная аналитика: Мониторинг и оптимизация каждой рекламной кампании, ежемесячный отчет по конверсии.\n" +
               "- PR и партнерская реклама\n","\uD83C\uDFC5 ВИП"));
       tariflar.add(new Tariflar(5L,"\uD83C\uDF96 Individual",null,":\n" +
               "\n" +
               "- Maxsus yondashuv: moslashtirilgan individual xizmatlar paketi. Bunda sizning talab va istaklaringiz o'rganib chiqiladi va unga ko'ra maxsus paket turi va narxi kelishuvga asosan shakllantiriladi\n","\n\n- Индивидуальный подход: Персонализированный пакет услуг. Ваша потребность и запросы изучаются, и на основе этого разрабатывается специальный пакет с индивидуально согласованной ценой.\n","\uD83C\uDF96 Индивидуальный"));

    }
}
