
@proforma @US01
Feature: US01 - Proforma Olusturma Islemleri

  @TC01 @pozitif
  Scenario: TC01 - Proforma basligi altinda bulunan zorunlu alanlar doldurularak proforma kaydedilebilmelidir
    Given kullanici sisteme giris yapmis durumda
    And proforma alt basligina tiklar
    And proforma listesi sayfasinin goruntulendigini dogrular
    And yeni butonuna tiklar
    And tarih bilgisinin otomatik olarak geldigini dogrular
    And musteri alanindan "GAZI VETERINER KLINIGI | GULCAN ELMAS" secer
    And yetkili bilgisinin "TESTER2" olarak otomatik geldigini dogrular
    And fatura bilgisinin "ATIF BEY MH. 11/2 SK. NO:45/A  GAZIEMIT / IZMIR" olarak otomatik geldigini dogrular
    And teslimat alanina "ATIF BEY MH. 11/2 SK. NO:45/A  GAZIEMIT / IZMIR" girer
    And kalemler alanindan "VH3 KANSAYIM CIHAZI" secer
    When kaydet butonuna tiklanir
    Then proformanin basariyla kaydedildigini dogrular
