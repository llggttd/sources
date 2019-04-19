<template>
  <div class="outer">
    <common-header :items="items" :active="0"></common-header>
    <main role="main" class="container">
    <!-- Window 10 Digital Activation -->
    <div class="tool row shadow">
      <div class="col-md-6 text-left">
        <h2>Window 10 Digital Activation</h2>
        <p class="lead">俄罗斯大神Ratuborus开发的另一款Windows 10激活工具。该工具使用Windows 10数字许可证来激活系统，当Windows 10被激活后会自动生成与硬件ID对应的许可证，该许可证会存储到微软的服务器上，在电脑硬件不变动的情况下，重新安装系统后，系统会自动激活，免去重新激活系统的麻烦。</p>
        <p>主要特性：</p>
        <ul class="small">
          <li>只可激活windows 10</li>
          <li>两种激活方式：HWID-硬件ID激活方式，KMS38-一次激活38年</li>
          <li>使用HWID方式激活后，只在硬件不变动，重新安装系统后系统可自动激活</li>
          <li>普通KMS激活只能激活180天，180天到期后要重新KMS激活，本工具KMS38模式一次可以激活38年</li>
          <li>系统登陆微软帐号后，激活许可会绑定到微软账号，可实现终身激活</li>
        </ul>
        <p>官方网站：<a href="https://free.appnee.com/v3-9-9-1-v1-1-7-aact/" target="_blank">https://free.appnee.com</a></p>
        <p>最新版本：1.3.7</p>
        <p>发布时间：2018-12-03</p>
        <p>下载：<a href="../share/W10DA_1.3.7.zip">W10DA_1.3.7.zip</a></p>
      </div>
      <div class="col-md-6 m-auto">
        <img class="img-fluid" src="../assets/w10da.png" />
      </div>
    </div>

    <!-- AACT -->
    <div class="tool row shadow">
      <div class="col-md-6">
        <h1>AACT</h1>
        <p class="lead">AAct是一款由俄罗斯网友Ratiborus制作的非常小巧实用的KMS激活工具，该工具体积小巧、单执行文件、绿色无残留，激活成功率高。</p>
        <p>主要特性：</p>
        <ul class="small">
          <li>支持Windows、Office零售版及批量授权版KMS激活</li>
          <li>支持手动安装及删除激活产品密钥</li>
          <li>支持手动创建及删除续期计划任务，通过创建计划任务来实现永久激活</li>
        </ul>
        <p>命令行运行时额外的启动参数：</p>
        <ul class="small">
          <li>/win=act - 在隐藏模式下运行程序，激活 Windows 并退出程序</li>
          <li>/ofs=act - 在隐藏模式下运行程序，激活 Office 并退出程序</li>
          <li>/wingvlk - 在隐藏模式下运行程序，安装 Windows 密钥并退出程序</li>
          <li>/ofsgvlk - 在隐藏模式下运行程序，安装 Office 密钥并退出程序</li>
          <li>/taskwin - 创建 Windows 重新激活任务</li>
          <li>/taskofs - 创建 Office 重新激活任务</li>
          <li>/tap - TAP模式</li>
          <li>/hook - Hook模式</li>
          <li>/auto - WinDivert, Hook and TAP自动模式</li>
        </ul>
        <p>官方网站：<a href="https://free.appnee.com/v3-9-9-1-v1-1-7-aact/" target="_blank">https://free.appnee.com</a></p>
        <p>最新版本：4.0</p>
        <p>发布时间：2019-02-17</p>
        <p>下载：<a href="../share/aact_4.0.zip">aact_4.0.zip</a></p>
      </div>
      <div class="col-md-6 m-auto">
        <img class="img-fluid" src="../assets/aact.png" />
      </div>
    </div>

    <!-- Rufus -->
    <div class="tool row shadow">
      <div class="col-md-6">
        <h1>Rufus</h1>
        <p class="lead">Rufus是一款制作USB启动盘的工具。</p>
        <p>主要特性：</p>
        <ul class="small">
          <li>工具小巧，绿色便捷，不用安装便可运行</li>
          <li>比其它镜像写入工具写入速度要快很多</li>
          <li>支持Windows、Linux系统镜像写入</li>
          <li>支持UEFI</li>
          <li>多语言支持</li>
        </ul>
        <p>官方网站：<a href="https://rufus.ie/" target="_blank">https://rufus.ie/</a></p>
        <p>最新版本：3.4</p>
        <p>发布时间：2018-12-05</p>
        <p>下载：<a href="../share/rufus-3.4.exe">rufus-3.4.exe</a></p>
      </div>
      <div class="col-md-6 m-auto">
        <img class="img-fluid" src="../assets/rufus.png" />
      </div>
    </div>

    <!-- UltraISO -->
    <div class="tool row shadow">
      <div class="col-md-6">
        <h1>UltraISO</h1>
        <p class="lead">UltraISO软碟通是一款功能强大、方便实用、老牌优秀的光盘映像文件制作/编辑/转换工具。</p>
        <p>主要特性：</p>
        <ul class="small">
          <li>可以直接编辑ISO文件，从ISO中提取文件和目录</li>
          <li>可以从CD - ROM制作光盘映像或者将硬盘上的文件制作成ISO文件</li>
          <li>同时还可以处理ISO文件的启动信息，从而制作可引导光盘</li>
          <li>使用UltraISO，你可以随心所欲地制作/编辑/转换光盘映像文件</li>
        </ul>
        <p>官方网站：<a href="https://rufus.ie/" target="_blank">https://rufus.ie/</a></p>
        <p>最新版本：9.7.1</p>
        <p>发布时间：2018-01-24</p>
        <p>下载：<a href="../share/uiso9_cn.exe">uiso9_cn.exe</a></p>

        <div class="alert alert-warning" role="alert">
          <p class="text-">激活</p>
          <span>用户名：redcaps</span>
          <br/>
          <span>激活码：82C6-3DEF-AB07-0EC0</span>
        </div>
      </div>
      <div class="col-md-6 m-auto">
        <img  class="img-fluid" src="../assets/ultraiso.png" />
      </div>
    </div>

    <!-- AIDA64 -->
    <div class="tool row shadow">
      <div class="col-md-6 text-left">
        <h1>AIDA64</h1>
        <p class="lead">
          AIDA64是一个测试软硬件系统信息的工具。它可以进行底层硬件扫描，详细的显示出PC硬件每一个方面的信息。支持上千种(3400+)主板，支持上百种(360+)显卡，支持对并口/串口/USB这些PNP设备的检测，支持对各式各样的处理器进行检测。支持查看远程系统信息和管理，结果报告导出为HTML、XML功能。
        </p>
        <p>主要特性：</p>
        <ul class="small">
          <li>提供cpu、磁盘和内存基准。AIDA64提供了一个64位的基准来对计算机处理各种数据任务的速度进行衡量。内存和缓存的基准可用来分析系统的内存带宽和延迟，处理器的基准利用MMX，3DNOW！和SSE指令</li>
          <li>监控温度、电压和散热风扇监控。支持支持超过150个传感器设备来检测温度、电压、风扇散热转速以及功率消耗</li>
          <li>诊断硬件功能，AIDA64的硬件检测能力十分优秀，检测的结果也是同类产品中较详细准确的</li>
          <li>软件界面清晰，操作简单，小白用户也能很快上手操作</li>
        </ul>
        <p>官方网站：<a href="https://www.aida64.com/downloads" target="_blank">https://www.aida64.com/downloads</a></p>
        <p>最新版本：5.99.4900</p>
        <p>发布时间：2018-11-20</p>
        <p>下载：<a href="../share/aida64extreme599.zip">aida64extreme599.zip</a></p>

        <div class="alert alert-warning" role="alert">
          <p class="text-">激活</p>
          <span>激活码：FKUR4-C3LD6-UCD59-2D8E4-UYD32</span>
        </div>
      </div>
      <div class="col-md-6 m-auto">
        <img class="img-fluid" src="../assets/aida64.png" />
      </div>
    </div>
    </main>
    <common-footer></common-footer>
  </div>
</template>

<script>
import CommonHeader from '@/components/CommonHeader'
import CommonFooter from '@/components/CommonFooter'
import { items } from '@/pages/tools/router'

export default {
  name: 'Tools',
  components: {
    CommonHeader,
    CommonFooter
  },
  data () {
    return {
      items
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .tool {
  background-color: antiquewhite;
  margin: 2rem 0rem;
  padding: 3rem 1.5rem;
  text-align: left;
  border: 1px solid antiquewhite;
  border-radius: 1.0rem
 }

</style>
