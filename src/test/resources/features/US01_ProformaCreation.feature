@US01
Feature: Proforma Oluşturma ve Doğrulama

  Background:
    Given kullanici sisteme giris yapmis durumda
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

  @TC03
  Scenario: Zorunlu alan kontrolü - Boş alanlar - 2
    When yeni butonuna tiklar
    And tarih bilgisinin otomatik olarak geldigini dogrular
    And musteri alani bos birakilir
    And kalemler alanindan "VH3 KANSAYIM CİHAZI" secer
    When kaydet butonuna tiklanir
    Then Sistem Hata mesajı göstermelidir

    @TC04
    Scenario: Geçersiz tarih formatı kontrolü
      When yeni butonuna tiklar
      And tarih alanina "a" girer
      And Kalemler alanindan veri secilmeye calisildiginda
      Then sistem hata mesajı göstermelidir

      @TC05
      Scenario: Yeni müşteri (Cari) ekleme
        When yeni butonuna tiklar
        And tarih bilgisinin otomatik olarak geldigini dogrular
        And musteri alaninda + butonuna tıklanir
        And Tabela adi alanina "NRK" girer
        And Kaydet butonuna tiklanir
        Then Musteri alaninda "NRK" secilmis oldugu dogrulanir

        @TC06
        Scenario: Yeni müşteri ekleme - Boş alanlar
          When yeni butonuna tiklar
          And musteri alaninda + butonuna tıklanir
          And Tabela adi alani bos birakilir
          And yeni musteri kaydet butonuna tiklanir
          Then sistemin musteri kaydını gerceklestirmedigi dogrulanir


          @TC07
          Scenario: Seçilen Müşteri bilgisini düzenleme
            When yeni butonuna tiklar
            And musteri alanindan secer
            And Duzenle butonuna tiklanir
            And Fatura unvani alanina "NRK" girer
            And Tabela adi alaninin otomatik geldigi dogrulanir
            And Vergi no alanina "1234567890" girer
            And Vergi dairesi alanina "ABC" girer
            And Satis Temsilcisi alanina "RUMEYSA KISACIK" girer
            And Genel Bilgiler basligina tiklanir
            And Portfoy alanina "RUMEYSA KISACIK" girer
            And Adres Bilgileri basligina tiklanir
            And İl alanindan "BURDUR" secilir
            And İlçe alanindan "TEFENNİ" secilir
            And Posta kodu alanina "15000" girer
            And Adres alanina "test" girer
            And Adres alaninda Kaydet butonuna tiklanir
            And Adres Listesi alaninda kaydedilen bilgilerin görüntülendigi dogrulanir
            And Yetkili Adi alanina "TESTER" girilir
            And Yetkili adi alaninda Kaydet butonuna tiklanir
            And Genel kayit icin Kaydet-Proforma butonuna tiklanir
            Then Duzenlenen bilgilerin Proforma kayit alaninda görüntülendigi dogrulanir
