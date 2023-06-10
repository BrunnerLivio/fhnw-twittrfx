const plugins = [
  "@semantic-release/commit-analyzer",
  "@semantic-release/release-notes-generator",
  [
    "@semantic-release/exec",
    {
      verifyReleaseCmd: "echo ${nextRelease.version} > .VERSION",
    },
  ],
  process.env.DRY_RUN === "true"
    ? null
    : [
        "@semantic-release-plus/docker",
        {
          name: process.env.IMAGE_NAME?.toLowerCase() || "twittrfx-server",
          registry: process.env.REGISTRY || "ghcr.io",
        },
      ],
  process.env.DRY_RUN === "true"
    ? null
    : [
        "@semantic-release/github",
        {
          assets: [
            {
              path: "**/*.jar",
              label: "TwittrFX Jar",
            },
          ],
        },
      ],
].filter(Boolean);

module.exports = {
  branches: [
    "+([0-9])?(.{+([0-9]),x}).x",
    "master",
    "next",
    "next-major",
    { name: "beta", prerelease: true },
    { name: "alpha", prerelease: true },
  ],
  plugins,
};
