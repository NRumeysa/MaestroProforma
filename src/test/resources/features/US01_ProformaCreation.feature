@US01
Feature: Proforma Oluşturma ve Doğrulama

  Background: 
    Given Kullanıcı hesaba giriş yapmış olmalıdır
    And proforma alt basligina tiklar
    And proforma listesi sayfasinin goruntulendigini dogrular

  @TC01
  Scenario: Başarılı proforma oluşturma
    When yeni butonuna tiklar
    And tarih bilgisinin otomatik olarak geldigini dogrular
    And musteri alanindan secer
    And yetkili bilgisinin "KISACIK" olarak otomatik geldigini dogrular
    And fatura bilgisinin "(T) ATIF BEY MH. 11/2 SK. NO:45/A GAZİEMİR / İZMİR" olarak otomatik geldigini dogrular
    And teslimat alanina "ATIF BEY" girer
    And kalemler alanindan "VH3 KANSAYIM CİHAZI" secer
    When kaydet butonuna tiklanir
    Then proformanin basariyla kaydedildigini dogrular

  @TC02
  Scenario: Zorunlu alan kontrolü - Boş alanlar
    When yeni butonuna tiklar
    And musteri alanindan secer
    And Tarih alani bos birakilir
    And Kalemler alanindan veri secilmeye calisildiginda
    Then Sistem hata mesajı göstermelidir
