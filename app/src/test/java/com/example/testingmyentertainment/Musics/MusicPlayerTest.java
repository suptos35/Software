package com.example.testingmyentertainment.Musics;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

public class MusicPlayerTest {
    @Test
    public void testSongSearchAndPlay() {
        String[] songNames = {"Bhalo lage", "Dokhhin khola janala","Eto Chaoa Niye Kotha Jai ","Ghore pherar gaan","Kisher Eto Tara","Kotha Dayo Bondhu","Manush Chena Daye","Amar Priya Cafe","Bhikkhetei Jabo","Moymonsingha Geetika","Pakhider Sure Gaan","Prithibi Ta Naki Chhoto Hote Hote","Sangbighno Pakhhikul","Sara Raat","Sat Tala Bari","Sei Phuler Daal","Taakey Joto Tarai Dure",
                "Tai Janai Gaane","Telephone","Tomay Dilam","Kolakata kolkata","Chaitrer Kafan","Dhandar thekeo jotil","Neel sagore"};
        String[] songUrls = {
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FBhalo%20Lage%20-%20Moheener%20Ghoraguli%20II%20%E0%A6%AD%E0%A6%B2%E0%A6%AC%E0%A6%B8%20%E0%A6%9C%E0%A6%AF%E0%A7%8E%E0%A6%B8%E0%A6%A8%E0%A6%AF%20%E0%A6%95%E0%A6%B6%E0%A6%AC%E0%A6%A8%20%E0%A6%9B%E0%A6%9F%E0%A6%A4%20(Lyrics).mp3?alt=media&token=76d03888-cf04-42fd-be18-cc83731ac912",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FDokhhin%20Khola%20Janala.mp3?alt=media&token=c2705886-c86e-497b-98d4-251debb9e8c3",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FEto%20Chaoa%20Niye%20Kotha%20Jai%20by%20Moheener%20Ghoraguli%20(1).mp3?alt=media&token=3684332e-e21f-44ec-b46a-d34c8c64b583",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FEto%20Chaoa%20Niye%20Kotha%20Jai%20by%20Moheener%20Ghoraguli.mp3?alt=media&token=c0d58a5a-6df7-4223-a645-a8e24392ff39",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FGhore%20pherar%20gaan%20mohiner%20ghoraguli.mp3?alt=media&token=1f90c97e-b05c-406b-8a55-f06357c98a79",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FKisher%20Eto%20Tara.mp3?alt=media&token=b4b10978-c517-4c12-a0a1-1458ca9533d3",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FKotha%20Dayo%20Bondhu.mp3?alt=media&token=2ee45610-d83b-4686-8d55-9b4deebf922c",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FManush%20Chena%20Daye.mp3?alt=media&token=84668557-f524-47fb-b153-b4dc47fcbf2e",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FMohiner%20Ghoraguli%20-%20Amar%20Priya%20Cafe%20%20Kape%20Kape%20Amar%20Hiya%20Kape%20%20Bhoot%20Ray%20Dipto.mp3?alt=media&token=3c70e5e8-49c1-489f-87cc-8e6f728a79c1",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FMohiner%20Ghoraguli%20-%20Bhikkhetei%20Jabo.mp3?alt=media&token=d3cd61a3-aff6-498c-9e47-3e2df276dd72",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FMoymonsingha%20Geetika.mp3?alt=media&token=f1e1d1ae-777b-4219-882c-b22ac73741dc",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FPakhider%20Sure%20Gaan.mp3?alt=media&token=f2e5ac5e-d75b-4bb9-9d67-7eb0626c55ba",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FPrithibi%20Ta%20Naki%20Chhoto%20Hote%20Hote.mp3?alt=media&token=3a2b1676-e745-4520-956d-ef4887a26f50",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FSangbighno%20Pakhhikul.mp3?alt=media&token=c7126df6-dc7c-41df-be19-89c1e485d9e8",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FSara%20Raat.mp3?alt=media&token=5d84f34a-e645-46aa-8d74-60cddd3fffb8",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FSat%20Tala%20Bari.mp3?alt=media&token=a2fa4ef3-c475-4e5b-87cd-286b04aa372d",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FSei%20Phuler%20Daal.mp3?alt=media&token=d3711914-ffb1-4644-9c77-6cce6019def6",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FTaakey%20Joto%20Tarai%20Dure.mp3?alt=media&token=69e63913-0108-4264-ac35-56cc68eba52c",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FTai%20Janai%20Gaane.mp3?alt=media&token=487c9eed-7195-4dfe-bad2-f3134e6857b3",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FTelephone%20-%20Moheener%20Ghoraguli%20(Lyrics).mp3?alt=media&token=c7a59ae6-2749-4483-a63d-5581ca962e37",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2FTomay%20Dilam%20-%20Moheener%20Ghoraguli.mp3?alt=media&token=57a9b2c3-9c56-4da8-a907-d8dc8d43146a",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2F%E0%A6%95%E0%A6%B2%E0%A6%95%E0%A6%A4%20%E0%A6%95%E0%A6%B2%E0%A6%95%E0%A6%A4%20(%E0%A6%AE%E0%A6%B9%E0%A6%A8%E0%A6%B0%20%E0%A6%98%E0%A7%9C%E0%A6%97%E0%A6%B2%2C%20)%20-%20Kolkata%20Kolkata%20(Moheener%20Ghoraguli%2C%201977).mp3?alt=media&token=3554418a-5007-4d37-90df-4e0d106446c6",
                "https://firebasestorage.googleapis.com/v0/b/onlinemusic-9f1a8.appspot.com/o/MohinerGhoraguli%2F%E0%A6%9A%E0%A6%A4%E0%A6%B0%E0%A6%B0%20%E0%A6%95%E0%A6%AB%E0%A6%A8%20(%E0%A6%AE%E0%A6%B9%E0%A6%A8%E0%A6%B0%20%E0%A6%98%E0%A7%9C%E0%A6%97%E0%A6%B2%2C%20)%20-%20The%20Shroud%20of%20Spring%20(Moheener%20Ghoraguli%2C%201979).mp3?alt=media&token=7ac14bde-48a9-43be-bc21-9849be83b493",



        };
        MusicPlayer mockedMusicPlayer = Mockito.mock(MusicPlayer.class);
        Mockito.when(mockedMusicPlayer.getUrlForSong("Bhalo lage")).thenReturn(songUrls[0]);

        // Assume searchView text changed to "Bhalo lage" and item clicked
        String url = mockedMusicPlayer.getUrlForSong("Bhalo lage");
        mockedMusicPlayer.playSong(url);

        Mockito.verify(mockedMusicPlayer).playSong(songUrls[0]);
    }
}
