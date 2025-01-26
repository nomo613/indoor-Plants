<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>Indoor Plants</title>
</head>
<body>
   <header>
     <div class="text-center py-3">
      <h1>INDOOR PLANTS</h1>
    </div>
   </header>
   <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="#" onclick="navigateToLogin()">会員ログイン</a></li>
      <li class="breadcrumb-item active" aria-current="page">Plants List</li>
      <script>
        function navigateToLogin(){
          window.location.href = "login";
        }
      </script>
    </ol>
  </nav>
<main class="container">
  <section>
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="images/D-1.jpg" class="d-block w-100" alt="Sample Image">
          <div class="carousel-caption d-none d-md-block text-center">
            <h4 class="text-white">A moment of healing for the heart and space.</h4>
            <!--心と空間に癒しのひとときを-->
          </div>
        </div>
        <div class="carousel-item">
          <img src="images/D-2.jpg" class="d-block w-100" alt="Sample Image">
          <div class="carousel-caption d-none d-md-block">
            <h4>Caring for houseplants requires regular watering and proper sunlight.</h4>
            <!--観葉植物のお手入れには定期的な水やりと適切な日光が必要です-->
          </div>
        </div>
        <div class="carousel-item">
          <img src="images/D-3.jpg" class="d-block w-100" alt="Sample Image">
          <div class="carousel-caption d-none d-md-block">
            <h4>Relax your mind and body.</h4>
            <!--心身共にリラックス-->
          </div>
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </section>


  <section>
    <h6>リラックス効果・空気清浄効果</h6>
    <p>観葉植物が空間にあることで、リラックスして過ごすことができます。<br>
      植物は視覚的にも心地よく、ストレスを軽減する効果があります。<br>
      また、NASAの研究によると、観葉植物には有害物質を吸収し、<br>
      空気を浄化してくれる空気清浄効果があるとも言われています。
    </p>
  </section>

  <span class="dli-chevron-down"></span><br>
  <span class="dli-chevron-down"></span><br>
  <span class="dli-chevron-down"></span>

   <section class="text-center md-4">
    <h2>初めての観葉植物、自分にぴったりな植物をみつけましょう！</h2>
    <%-- <h2>新規登録は↓↓↓</h2>--%>
        <div class="row">
          <div class="col">
            <dl>
              <dt><a class="circle" href="#hardy" >強 い</a></dt>
                  <dd>
                    乾燥に強いので水を<br>
                    忘れても大丈夫<br>
                    耐寒性、寒い冬に強い
                  </dd>
            </dl>
          </div>
          <div class="col">
            <dl>
              <dt><a class="circle" href="#size" >大きさ</a></dt>
                  <dd>
                    空間とのバランス<br>
                    棚上の小さいサイズ<br>
                    から天井まで<br>
                  </dd>
            </dl>
          </div>
          <div class="col">
            <dl>
              <dt><a class="circle" href="#recommendation" >おすすめ</a></dt>
                  <dd>
                    オシャレ空間に<br>
                    曲がりの植物で<br>
                    &nbsp;&nbsp;&nbsp;垢ぬけた印象に…<br>
                  </dd>
            </dl>
          </div>
        </div>
      </section>

    <section>
      <h2>--- POINT ---</h2>
       <ul>
          <li> 室内とのバランスを取るためにあらかじめ置き場のスペースを把握してね！</li>
          <li> 水の管理が簡単なサボテンや多肉植物は、手間がかからず魅力的！！</li>
          <li> まずは気に入った植物から始めるのも良いですね。愛情もって育つかも・・・。</li>
       </ul>
    </section>

    <span class="dli-chevron-down"></span><br>
    <span class="dli-chevron-down"></span><br>
    <span class="dli-chevron-down"></span><br>
    
       
    <style>
    img:hover {
    transform: scale(2.1); /* ホバー時に拡大 */
    box-shadow: 0 8px 8px rgba(0, 0, 0, 0.2); /* 影を追加 */
}
 </style>
  
    <section id="hardy">
          <h3>強  い</h3>
              <div class="flex-container">
                  <h5>フランスゴム</h5>
                  <img src="images/A-1.jpg" class="rounded" alt="Sample Image">
                  <ul class="list-bordered">
                    <p>光沢のある厚い葉が特徴の樹木</p>
                     <li>&lt;point&gt;</li>
                     <li>日当たりの良い場所を好みますが、<br>直射日光は避けださいね。</li>
                     <li>水やりは土が乾いてから、過湿に注意。</li>
                  </ul>
                  <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
              </div>
              <div class="flex-container">
                  <h5>サボテン</h5>
                  <img src="images/A-2.jpg" class="rounded" alt="Sample Image">
                  <ul class="list-bordered">
                    <p>乾燥地帯原産で、<br>葉が針に変化しているのが特徴</p>
                    <li>&lt;point&gt;</li>
                    <li>日当たりが良く風通しの良い場所を好みます。</li>
                    <li>水やりは控えめで、土が完全に乾いてから。</li>
                    <li>冬は水を控えて！休眠期にはいります。</li>
                 </ul>
                 <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
              </div>
              <div class="flex-container">
                  <h5>フィロデンドロン</h5>
                  <img src="images/A-3.jpg" class="rounded" alt="Sample Image">
                  <ul class="list-bordered">
                    <p>トロピカルな雰囲気を持つ<br>つる性または直立性の植物</p>
                    <li>&lt;point&gt;</li>
                    <li>明るい間接光を好むが、耐陰性もある。</li>
                    <li>土が乾いたら水やりをし湿度を高めに保つ。</li>
                    <li>定期的に葉を拭くと見栄えが良くなります。</li>
                 </ul>
                <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
              </div>
      </section>

      <section id="size">
          <h3>大 き さ</h3>
                <div class="flex-container">
                     <h5>モンステラ<br> (180-200cm)</h5>
                      <img src="images/B-1.jpg" class="rounded " alt="Sample Image">
                      <ul class="list-bordered">
                        <p>大きな葉に穴が開くユニークな姿が特徴</p>
                        <li>&lt;point&gt;</li>
                        <li>明るい間接光を好むが、半日陰でも育つ。</li>
                        <li>土が乾いてから水やり、過湿に注意！</li>
                        <li>支柱を立てると美しい形に‼</li>
                     </ul>
                     <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
                </div>
                <div class="flex-container">
                      <h5>モンステラ <br>(約100cm)</h5>
                      <img src="images/B-2.jpg" class="rounded " alt="Sample Image">
                      <ul class="list-bordered">
                        <p>大きな葉に穴が開くユニークな姿が特徴</p>
                        <li>&lt;point&gt;</li>
                        <li>明るい間接光を好むが、半日陰でも育つ。</li>
                        <li>土が乾いてから水やり、過湿に注意！</li>
                        <li>支柱を立てると美しい形に育つ。</li>
                     </ul>
                     <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
                </div>
                <div class="flex-container">
                      <h5 class="mons">モンステラ <br>(20-30cm)</h5>
                      <img src="images/B-3.jpg" class="rounded " alt="Sample Image">
                      <ul class="list-bordered">
                        <p>大きな葉に穴が開くユニークな姿が特徴</p>
                        <li>&lt;point&gt;</li>
                        <li>明るい間接光を好むが、半日陰でも育つ。</li>
                        <li>土が乾いてから水やり、過湿に注意！</li>
                        <li>支柱を立てると美しい形に育つ。</li>
                     </ul>
                     <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
                </div>
       </section>

       <section id="recommendation">
          <h3>お す す め</h3>
                <div class="flex-container">
                       <h5>カポック</h5>
                       <img src="images/C-1.jpg" class="rounded " alt="Sample Image">
                       <ul class="list-bordered">
                        <p>小さな丸い葉が広がる姿が特徴</p>
                        <li>&lt;point&gt;</li>
                        <li>日当たりと明るい室内ですが直射日光は避ける。</li>
                        <li>土が乾いたら水やり、根腐れに注意！</li>
                        <li>剪定して形を整えてじゅぶん好みに…</li>
                     </ul>
                     <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
                </div>
                <div class="flex-container">
                      <h5>パキラ</h5>
                      <img src="images/C-2.jpg" class="rounded " alt="Sample Image">
                      <ul class="list-bordered">
                        <p>手のひらのような形の葉が特徴で、<br>幸運を呼ぶ植物として人気</p>
                        <li>&lt;point&gt;</li>
                        <li>明るい間接光を好み耐陰性がある。</li>
                        <li>土が乾いてから水をたっぷりと。</li>
                        <li>幹を編んだ観葉植物としても人気。</li>
                     </ul>
                     <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
                </div>
                <div class="flex-container">
                      <h5>サンスベリア</h5>
                      <img src="images/C-3.jpg" class="rounded " alt="Sample Image">
                      <ul class="list-bordered">
                        <p>細長い剣のような葉が特徴で、<br>空気清浄効果があると言われる</p>
                        <li>&lt;point&gt;</li>
                        <li>明るい間接光から半日陰を好みます。</li>
                        <li>土が乾いてから水やりをする。<br>乾燥には非常に強い。</li>
                        <li>冬は水やりを控えめに。</li>
                     </ul>
                     <%-- <button type="button" class="btn btn-outline-success" onclick="location.href='PlantsList'">新規登録</button> --%>
                </div>
       </section>
        <button type="button" class="btn btn-outline-secondary" onclick="scrollToTop()">Topへ戻る</button>
  </main>
   <footer class="text-center py-3">
        <p>© 2025 Indoor Plants</p>
   </footer>
  <script>function scrollToTop() {window.scrollTo({ top: 0, behavior: 'smooth' });}</script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>