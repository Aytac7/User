#User və Profile Layihəsi
Bu layihə, #User və #Profile servislərini bir-biri ilə əlaqələndirmək üçün Feign Client və Interceptor Aspect istifadə edən bir tətbiqdir.

Təsvir
Bu sistemdə iki əsas komponent var:

User: İstifadəçi məlumatlarını idarə edən bir mikroservis.
Profile: İstifadəçi profil məlumatlarını idarə edən başqa bir mikroservis.
User mikroservisi, Profile mikroservisini çağırmaq üçün Feign Client istifadə edir. Interceptor Aspect isə User layihəsində tətbiq edilib və Feign client sorğularını izləmək üçün istifadə olunur.

##Əsas Texnologiyalar
Spring Boot: Mikroservislərin əsas çərçivəsi.
Feign Client: Mikroservislər arasında əlaqə qurmaq üçün istifadə edilir.
Aspect-Oriented Programming (AOP): Yalnızca User layihəsində tətbiq edilən, sorğuları izləmək üçün istifadə olunan aspektlər.
Spring Cloud: Feign Client istifadəsini asanlaşdıran texnologiya.
Layihə Quruluşu
1. User Microservice
User mikroservisi, istifadəçi məlumatlarını idarə edir və Profile mikroservisini Feign Client ilə çağırır.

Feign Client:
ProfileServiceClient: Profile mikroservisinin API-larını çağıran Feign Client interfeysidir.
Interceptor Aspect:
RequestInterceptor: Feign Client sorğuları üçün xüsusi başlıqlar, parametrlər və loqların əlavə edilməsini təmin edən interceptor.
2. Profile Microservice
Profile mikroservisi istifadəçi profillərini idarə edir və User mikroservisindən gələn sorğuları qəbul edir. Bu mikroservisin spesifik kodu bu layihədə yoxdur, amma User mikroservisindən gələn sorğuları idarə etmək üçün Feign Client istifadə edilir.
