# Maestro ERP - Proforma Test Otomasyonu

Bu proje, Maestro ERP sisteminin Satış Yönetimi modülü içerisindeki Proforma fonksiyonlarının test otomasyonunu içermektedir.

## Proje Hakkında

Bu test otomasyon projesi, Maestro ERP sisteminin Proforma işlemlerinin güvenilirliğini ve doğruluğunu test etmek amacıyla geliştirilmiştir. Proforma modülü, satış süreçlerinde önemli bir rol oynayan ön faturalama işlemlerini kapsamaktadır.

### Test Edilen Fonksiyonlar

- Proforma oluşturma
- Kalem ekleme ve düzenleme
- Ek gelirler ve maliyetler
- Tahsilat planı oluşturma
- Dosya ekleme ve yönetimi
- Notlar ve özel alanlar
- Proforma onaylama ve reddetme süreçleri

## Teknolojiler

- Java
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven

## Proje Yapısı

- `src/test/java/com/maestro/pages`: Page Object Model sınıfları
- `src/test/java/com/maestro/stepDefinitions`: Cucumber step tanımlamaları
- `src/test/java/com/maestro/runners`: Test koşum sınıfları
- `src/test/java/com/maestro/utilities`: Yardımcı metotlar ve araçlar
- `src/test/resources/features`: Cucumber feature dosyaları

## Paralel Test Çalıştırma

Proje, testlerin paralel olarak çalıştırılmasını desteklemektedir. Bu sayede test süreleri optimize edilmiştir.

## Raporlama

Test sonuçları detaylı raporlar halinde sunulmaktadır. Başarısız testler için otomatik olarak ekran görüntüleri kaydedilmektedir.

## Kurulum ve Çalıştırma

1. Projeyi klonlayın:
```bash
git clone https://github.com/NRumeysa/MaestroProforma.git
```

2. Gerekli bağımlılıkları yükleyin:
```bash
mvn clean install
```

3. Testleri çalıştırın:
```bash
mvn test
```
