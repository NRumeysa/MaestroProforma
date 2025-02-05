@proforma
Feature: Proforma Oluşturma

  Scenario: Proforma oluşturma ve kaydetme
    Given kullanici sisteme giris yapmis durumda
    And proforma alt basligina tiklar
    And proforma listesi sayfasinin goruntulendigini dogrular
    And yeni butonuna tiklar
    And tarih bilgisinin otomatik olarak geldigini dogrular
    And musteri alanindan secer
    And yetkili bilgisinin "KISACIK" olarak otomatik geldigini dogrular
    And fatura bilgisinin "(T) ATIF BEY MH. 11/2 SK. NO:45/A GAZİEMİR / İZMİR" olarak otomatik geldigini dogrular
    And teslimat alanina "ATIF BEY" girer
    And kalemler alanindan "VH3 KANSAYIM CİHAZI" secer
    When kaydet butonuna tiklanir
    Then proformanin basariyla kaydedildigini dogrular
