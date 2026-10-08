# SpigotTemplate

泠氏（LingsMC）Paper 插件开发模板：`SubCommand` 命令树 + 配置热重载 + 事件监听的最小可运行骨架。

## 技术栈

| 项目 | 值 |
|------|-----|
| 类型 | 插件（仅服务端） |
| 平台 | Paper 1.20.4 |
| Java | 17 |
| 构建 | Maven（maven-shade-plugin） |
| 测试 | JUnit 5 + Mockito |
| 元数据 | plugin.yml（version 由 Maven filtering 注入） |

## 目录结构

```
src/main/java/cn/lingsmc/spigottemplate/
├── SpigotTemplate.java         # 入口：生命周期装配配置 / 命令 / 监听器
├── commands/
│   ├── Commands.java           # 主命令执行器：参数分发 + Tab 补全
│   ├── CommandRegistry.java    # 子命令注册表（防重复注册）
│   ├── SubCommand.java         # 子命令接口
│   └── subcommands/            # 各子命令实现（help / reload）
├── constants/
│   ├── CommandConstants.java   # 命令名、别名、权限节点
│   ├── ConfigConstants.java    # 配置键名
│   └── MessageConstants.java   # 玩家可见文案（颜色码遵循品牌色板）
├── listener/
│   └── AnyListener.java        # 事件监听示例
└── utils/                      # 工具类（private 构造器 + 静态方法）
    ├── ConfigUtils.java        # 配置加载 / 重载 / 读取
    ├── PermissionUtils.java    # 权限校验
    └── StringUtils.java        # 字符串纯函数
src/main/resources/             # plugin.yml + config.yml
src/test/java/                  # JUnit5 单元测试
```

## 初始化 / 使用

1. 克隆模板到新项目目录：`git clone https://github.com/Lings-MC/SpigotTemplate.git <项目>/`。
2. 按下方清单重命名，把模板标识换成你的插件标识。
3. 在项目目录执行 `mvn clean package`，产物在 `target/SpigotTemplate-<version>.jar`。
4. 将 jar 复制到 Paper 服务器的 `plugins/` 目录，重启服务器。

| # | 文件 | 改什么 |
|---|------|--------|
| 1 | `pom.xml` | `artifactId`、`name`、`version`（`groupId` 默认保持 `cn.lingsmc`） |
| 2 | `src/main/java/cn/lingsmc/spigottemplate/` 目录 | 包名 → `cn.lingsmc.<插件名小写>`（移动目录并批量替换包声明与 import） |
| 3 | `SpigotTemplate.java` | 类名 → `<插件名>`；类内引用同步 |
| 4 | `plugin.yml` | `name`、`main`（含包路径）、`authors`；`version` 保持 `${project.version}` |
| 5 | `CommandConstants.java` | `ALIAS` 改为新命令别名；`PERMISSION_ADMIN` 改为新权限节点（同步 `plugin.yml`） |
| 6 | `MessageConstants.java` | 文案与插件名引用 |
| 7 | `ConfigConstants.java` | 配置键名（同步 `config.yml`） |

## 常用命令

- `/st` — 输出运行横幅与命令列表
- `/st help` — 输出命令帮助
- `/st reload` — 重载配置文件（需权限）

## 配置

| 配置项 | 默认值 | 说明 |
|--------|--------|------|
| `welcome-message` | `true` | 玩家加入服务器时是否发送欢迎提示 |

## 权限

| 权限节点 | 默认 | 说明 |
|----------|------|------|
| `spigottemplate.admin` | op | 执行管理命令（如 `/st reload`） |

## 常见问题

### 构建报错找不到 `getInstance()`

JDK 23 起 javac 不再自动运行 classpath 上的注解处理器，Lombok 会被跳过。`pom.xml` 已通过 `annotationProcessorPaths` 显式声明 Lombok，请勿删除该配置。

### 想接入 MockBukkit 做集成测试

模板默认为「纯逻辑用 JUnit5」路线。需要测试命令注册 / 事件触发时，在 `pom.xml` 增加对应 Paper 版本的 MockBukkit 依赖（`scope=test`），用 `MockBukkit.mock()` / `MockBukkit.load()` 驱动。

### `plugin.yml` 里的版本号没被替换

`pom.xml` 的 `<resources>` 必须保持 `<filtering>true</filtering>`，`plugin.yml` 才能读取 `${project.version}`。

## License

MIT License（见 LICENSE 文件）。